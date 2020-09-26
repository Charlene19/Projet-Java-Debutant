package ch.epfl.moocprog.gfx;

import static ch.epfl.moocprog.app.Context.getApplication;
import static ch.epfl.moocprog.config.Config.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import ch.epfl.moocprog.Anthill;
import ch.epfl.moocprog.Environment;
import ch.epfl.moocprog.Termite;
import ch.epfl.moocprog.utils.Time;
import ch.epfl.moocprog.ToricPosition;
import ch.epfl.moocprog.utils.Vec2d;
import ch.epfl.moocprog.app.Context;
import javafx.animation.AnimationTimer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public final class JavaFXContainer extends javafx.application.Application {
	
	private int width, height; 
	private int MAXWIDTH = (int)(900*1.2);
	private int MAXHEIGHT = (int)(600*1.2);
	private Environment environment;
	private EnvironmentGraphicRenderer renderer;
	private boolean bPause;
	private double curX, dX, curY, dY;
	private ObjectProperty<Double> zoomScale;

	private Map<String, ObjectProperty<String>> properties;
	private Map<String, ObjectProperty<String>> defaultProperties;
	
	private double maxDT = 5.0;
	private double minDT = 0.1;

	private GameLoop gameLoop;

	@Override
	public void start(Stage stage) {
		startGame(stage);

	}

	public void startGame(Stage stage) {
		bPause = true;

		BorderPane root = new BorderPane();
		environment = new Environment();

		Map<String, Boolean> m = makeDebuStructure();
		Node debugControl = DebugControlPane(m);
		
		width = (int)Math.min (environment.getWidth(), MAXWIDTH);
		height = (int) Math.min (environment.getHeight(), MAXHEIGHT);
		renderer = new EnvironmentGraphicRenderer(m,width, height);

		zoomScale = new SimpleObjectProperty<Double>();
		zoomScale.set(1.0);

		rendererGenerator(environment);

		Pane rendererContainer = new Pane(renderer);
		rendererContainer.setStyle("-fx-background-color :lightblue;");

		//Group g = new Group(rendererContainer);
		defaultProperties = new LinkedHashMap<String, ObjectProperty<String>>();
		fillPropertyMap(defaultProperties, null);

		root.setCenter(new Pane(rendererContainer));

		root.setTop(controlPanel(root, stage));
		root.setRight(configPanel(root));
		root.setBottom(debugControl);
		rendererContainer.scaleYProperty().bind(zoomScale);
		rendererContainer.scaleXProperty().bind(zoomScale);
		zoomNav(rendererContainer, root.getCenter());
		gameLoop = new GameLoop();
		gameLoop.start();

		Scene scene = new Scene(root);
		stage.setTitle("Hello Ants !");
		stage.setScene(scene);
		stage.show();
	}
	
	
	/**
	 * data structure for the Debug Panel
	 * @return a Map of boolean triggers for every property debug
	 */
	private Map<String, Boolean> makeDebuStructure() {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("Position: ", Boolean.valueOf("false"));
		map.put("Speed: ", Boolean.valueOf("false"));
		map.put("HitPoints: ", Boolean.valueOf("false"));
		map.put("LifeSpan: ", Boolean.valueOf("false"));
		map.put("State: ", Boolean.valueOf("false"));
		map.put("Quantity: ", Boolean.valueOf("false"));
		return map;

	}
	
	
	private void fillPropertyMap(Map<String, ObjectProperty<String>> propertiesMap,GridPane configPane) {
		File configFile = new File("res/app.cfg");
		if (configFile != null) {

			try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
				String line;
				int i = 0;
				while ((line = br.readLine()) != null) {
					String[] configProp = line.split(":");
					if (configProp.length == 3) {

						Label propName = new Label(configProp[0] + ":" + configProp[1]);
						TextField entry = new TextField(configProp[2]);
						if (configPane !=null) {
							configPane.add(propName, 0, i);
							configPane.add(entry, 1, i);
						}

						ObjectProperty<String> propertyLink = new SimpleObjectProperty<String>();
						propertyLink.bind(entry.textProperty());
						propertiesMap.put(propName.getText(), propertyLink);

					} else {
						if (configPane != null) {
							Label propName = new Label("__________________________");
							configPane.add(propName, 0, i);
						}
						propertiesMap.put(String.valueOf(i), null);
					}

					i++;

				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}
	/**
	 * Creates a configuration panel using the configuration file to then modify it from the app
	 * rather than the file itself
	 * @param root the root node
	 * @return a Vertical Box that contains the configuration fields
	 */
	private VBox configPanel(BorderPane root) {
		properties = new LinkedHashMap<String, ObjectProperty<String>>();
		
		VBox configContainer = new VBox();
		ScrollPane sc = new ScrollPane();

		GridPane configPane = new GridPane();
		fillPropertyMap(properties, configPane);

		sc.setContent(configPane);
		sc.setFitToHeight(true);

		Button apply = new Button("Apply");
		apply.setOnAction(e -> {

			parseOutCFG(properties);
			Context.getApplication().reload();
			root.setRight(configPanel(root));

		});
		Button reset = new Button("Reset");
		reset.setOnAction(e -> {

			parseOutCFG(defaultProperties);
			Context.getApplication().reload();
			root.setRight(configPanel(root));

		});

		configContainer.getChildren().add(sc);
		configContainer.getChildren().add(apply);
		configContainer.getChildren().add(reset);
		configContainer.setPrefHeight(MAXHEIGHT);
		return configContainer;

	}
	
	/**
	 * Check if any value is non valid for a given feild
	 * @return false if there exists a non valid value
	 */
	private boolean noBadPrams() {

		for (String key : this.properties.keySet()) {

			if (properties.get(key) != null) {
				if (key.split(":")[1].equals("int")) {
					try {
						Integer.valueOf(properties.get(key).get());

					} catch (NumberFormatException e) {
						return false;
					}

				} else {
					try {
						Double.valueOf(properties.get(key).get());

					} catch (NumberFormatException e) {
						return false;
					}

				}

			}

		}
		return true;

	}
	
	/**
	 * Method that parses the modified configurations to then print it into the configuration file
	 */
	private void parseOutCFG(Map<String, ObjectProperty<String>> propertiesMap) {

		if (noBadPrams()) {

			File configFile = new File(Context.CONFIG_PATH);

			if (configFile != null) {

				try {
					FileOutputStream configOut = new FileOutputStream(configFile, false);
					PrintWriter configPrint = new PrintWriter(configOut);

					for (String key : propertiesMap.keySet()) {
						String out;
						if (propertiesMap.get(key) != null) {

							out = key + ":" + propertiesMap.get(key).get() + System.lineSeparator();
							
							//TIME_FACTOR bounded parsing
							if (key.equals("TIME_FACTOR:double") && Double.parseDouble(propertiesMap.get(key).get()) > maxDT) {
								out =key + ":" + maxDT + System.lineSeparator();
								
							}
							if (key.equals("TIME_FACTOR:double") && Double.parseDouble(propertiesMap.get(key).get()) < minDT) {
								out =key + ":" + minDT + System.lineSeparator();
								
							}
							
							
							configPrint.print(out);

						} else {

							configPrint.println("");

						}

					}
					configPrint.close();

				}

				catch (FileNotFoundException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	
	/**
	 * Adds a button array for debugging properties
	 * @param debugStruct
	 * @return
	 */
	private Node DebugControlPane(Map<String, Boolean> debugStruct) {
		if (debugStruct == null) {
			return null;
		}

		GridPane buttonGrid = new GridPane();
		int i = 0;
		for (String key : debugStruct.keySet()) {
			Button debug = new Button(key);

			debug.setOnAction(e -> {
				debugStruct.computeIfPresent(key, (k, v) -> !v);

			});
			buttonGrid.add(debug, i++, 0);
		}

		return buttonGrid;
	}

	/***
	 * reads the file config.txt and generates simulation content using this file
	 * 
	 * @param environment
	 */
	private void rendererGenerator(Environment environment) {

		File configFile = new File(Context.INIT_PATH);
		if (configFile != null) {

			try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
				String line;
				while ((line = br.readLine()) != null) {

					String noSpace = line.replaceAll("\\s+", "");
					noSpace = noSpace.toLowerCase();

					if (Pattern.matches("\\p{Alpha}+:\\d+,\\d+", noSpace)) {
						String className = noSpace.split(":")[0];
						int x = Integer.parseInt(noSpace.split(":")[1].split(",")[0]);
						int y = Integer.parseInt(noSpace.split(":")[1].split(",")[1]);
						if (className.equals("anthill")) {

							environment.addAnthill(new Anthill(new ToricPosition(x, y)));
						} else if (className.equals("termite")) {
							Termite t = new Termite(new ToricPosition(x, y));

							environment.addAnimal(t);

						} else {

							System.out.println("Couldn't instantiate :" + line);
							;
						}

					}

				}
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	/**
	 * Creates the panel that will contain control buttons
	 * 
	 * @return the created panel of type Node
	 */
	private Node controlPanel(BorderPane root, Stage stage) {
		GridPane control = new GridPane();
		SimpleStringProperty pausePlayText = new SimpleStringProperty("Play");
		SimpleStringProperty restartText = new SimpleStringProperty("Restart");

		Button pause = new Button();
		pause.textProperty().bind(pausePlayText);
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				bPause = !bPause;
				pausePlayText.setValue(bPause ? "Play " : "Pause");
			}
		});

		Button restart = new Button();
		restart.textProperty().bind(restartText);
		restart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameLoop.stop();
				startGame(stage);
			}
		});

		// zoom implementation in progress
		Button zoomUP = new Button();
		zoomUP.textProperty().set("+");
		zoomUP.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				zoomScale.set(zoomScale.get() + 0.1);
			}
		});
		Button zoomDown = new Button("-");

		zoomDown.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				zoomScale.set(zoomScale.get() - 0.1);
			}
		});

		
		// control.add(zoomUP, 1, 0);
		// control.add(zoomDown, 2, 0);
		control.add(pause, 0, 0);
		control.add(restart, 1, 0);

		return control;
	}
	/**
	 * Manages the zoom and translation actions
	 * @param n the node to zoom in and translate
	 * @param center the part of the borderPane containing the node
	 */
	private void zoomNav(Node n, Node center) {
		center.setOnScroll(e -> {
			double scrollY = 0.05 * e.getDeltaY() / Math.abs(e.getDeltaY());
			double deltaZoom = Math.max(1.0, zoomScale.get() + scrollY);
			zoomScale.set(deltaZoom);
			if(scrollY<0.0) {
				relocateNode(n,0, 0);
			}

		});
		n.setOnMousePressed(e -> {
			curX = e.getX();
			curY = e.getY();
		});
		n.setOnMouseDragged(e -> {
			if (zoomScale.get() > 1.0) {
				
				dX = e.getX() - curX;
				dY = e.getY() - curY;
				relocateNode(n, dX, dY);
				
			}
		});

	}
	
	/**
	 * Dynamically relocates the simulation's node during translation or zoom actions
	 * @param n the node to relocate
	 * @param deltaX the X translation
	 * @param deltaY the Y translation
	 */
	void relocateNode(Node n, double deltaX,double deltaY) {
		
		double limitInfX = - width / 2.0 * (1 - zoomScale.get());
		double limitInfY = - height / 2.0 * (1 - zoomScale.get());
		double limitMaxX = -limitInfX;
		double limitMaxY = -limitInfY;
		
		double newX = Math.max(Math.min(limitInfX, n.getLayoutX() + deltaX), limitMaxX);
		double newY = Math.max(Math.min(limitInfY, n.getLayoutY() + deltaY), limitMaxY);
		n.relocate(newX, newY);
	}

	private final class GameLoop extends AnimationTimer {
		private long before = System.nanoTime();
		

		@Override
		public void handle(long now) {
			long delta = (now - before) / 1_000_000;
			
			Time dt;
			double timeFactor = Math.min(maxDT,getApplication().getConfigManager().getDouble(TIME_FACTOR));
			
			if (!bPause) {
				dt = Time.fromMilliseconds(delta).times(timeFactor);

				environment.update(dt);

			} else {
				dt = Time.fromMilliseconds(0);
			}
			renderer.clear();
			environment.renderEntities(renderer);

			before = now;
		}
	}
}
