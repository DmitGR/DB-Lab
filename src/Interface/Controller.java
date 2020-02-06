package Interface;

import Logic.DBConnect;
import Logic.Student;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sun.plugin2.message.Message;


import java.sql.SQLException;


public class Controller
{

    //region Table
    @FXML
    TableView<Student> tableView;
    @FXML
    TableColumn<Student, String> name;
    @FXML
    TableColumn<Student, Integer> math_grade;
    @FXML
    TableColumn<Student, Integer> math_hours;
    @FXML
    TableColumn<Student, Integer> java_grade;
    @FXML
    TableColumn<Student, Integer> java_hours;
    @FXML
    TableColumn<Student, Integer> economy_grade;
    @FXML
    TableColumn<Student, Integer> economy_hours;
    @FXML
    TableColumn<Student, Integer> physics_grade;
    @FXML
    TableColumn<Student, Integer> physics_hours;

    @FXML
    TableColumn<Student, Double> average_grade;
    //endregion

    private ObservableList<Student> list;
    private DBConnect dbConnect;
    @FXML
    private CheckBox autoUpdate;

    //region Add Form
    @FXML
    HBox addForm;
    @FXML
    TextField name_field;
    @FXML
    TextField math_field;
    @FXML
    TextField java_field;
    @FXML
    TextField economy_field;
    @FXML
    TextField physics_field;
    //endregion

    public void initialize()
    {
        
        dbConnect = new DBConnect();
        tableView.setEditable(true);
        tableView.setVisible(false);
        addForm.setDisable(true);

        
        //region AntiIncorrect Type
        math_field.setOnKeyReleased(event -> CheckType(math_field));
        math_field.setOnKeyPressed(event -> CheckType(math_field));
        math_field.setOnMouseReleased(event -> CheckType(math_field));

        java_field.setOnKeyReleased(event -> CheckType(java_field));
        java_field.setOnKeyPressed(event -> CheckType(java_field));
        java_field.setOnMouseClicked(event -> CheckType(java_field));

        economy_field.setOnKeyReleased(event -> CheckType(economy_field));
        economy_field.setOnKeyPressed(event -> CheckType(economy_field));
        economy_field.setOnMouseClicked(event -> CheckType(economy_field));

        physics_field.setOnKeyReleased(event -> CheckType(physics_field));
        physics_field.setOnKeyPressed(event -> CheckType(physics_field));
        physics_field.setOnMouseClicked(event -> CheckType(physics_field));
        //endregion

        //region Name column Property
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
                t ->
                {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                    Update();
                }
        );
        name.setEditable(true);
        //endregion

        //region Math column Property
        math_grade.setCellValueFactory(new PropertyValueFactory<>("math_grade"));
        math_grade.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        math_grade.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMath_grade(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMath_grade(0);
                    Update();
                }
        );
        
        math_grade.setEditable(true);

        math_hours.setCellValueFactory(new PropertyValueFactory<>("math_hours"));
        math_hours.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        math_hours.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMath_hours(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMath_hours(0);
                    Update();
                }
        );

        math_hours.setEditable(true);
        //endregion

        //region Java column Property
        java_grade.setCellValueFactory(new PropertyValueFactory<>("java_grade"));
        java_grade.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        java_grade.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMath_grade(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setJava_grade(0);
                    Update();
                }
        );
        java_grade.setEditable(true);

        java_hours.setCellValueFactory(new PropertyValueFactory<>("java_hours"));
        java_hours.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        java_hours.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setJava_hours(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setJava_hours(0);
                    Update();
                }
        );
        java_hours.setEditable(true);
        //endregion

        //region Economy column Property
        economy_grade.setCellValueFactory(new PropertyValueFactory<>("economy_grade"));
        economy_grade.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        economy_grade.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMath_grade(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setEconomy_grade(0);
                    Update();
                }
        );
        economy_grade.setEditable(true);

        economy_hours.setCellValueFactory(new PropertyValueFactory<>("economy_hours"));
        economy_hours.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        economy_hours.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEconomy_hours(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setEconomy_hours(0);
                    Update();
                }
        );
        economy_hours.setEditable(true);
        //endregion

        //region Physics column Property
        physics_grade.setCellValueFactory(new PropertyValueFactory<>("physics_grade"));
        physics_grade.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        physics_grade.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMath_grade(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhysics_grade(0);
                    Update();
                }
        );
        physics_grade.setEditable(true);

        physics_hours.setCellValueFactory(new PropertyValueFactory<>("physics_hours"));
        physics_hours.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        physics_hours.setOnEditCommit(
                t ->
                {
                    if (t.getNewValue() != null)
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPhysics_hours(t.getNewValue());
                    else (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhysics_hours(0);
                    Update();
                }
        );
        physics_hours.setEditable(true);
        //endregion

        //region Average Grade Column Property
        average_grade.setCellValueFactory(new PropertyValueFactory<>("average_grade"));
        average_grade.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        average_grade.setEditable(false);
        //endregion
    }

    @FXML
    public void Load() throws SQLException
    {
        list = dbConnect.GetData();

        tableView.setItems(list);
        tableView.setVisible(true);
        addForm.setDisable(false);
        if (list.isEmpty())
            InfoBox.display("Info", "Error in Get Data from server or\r" +
                    "Base is Empty!");
        else
            InfoBox.display("Info", "Data successful Loaded");
    }

    @FXML
    public void Save()
    {
        tableView.refresh();
        list = tableView.getItems();
        if (!list.isEmpty())
            dbConnect.Clear();
        for (Student student : list
                )
        {
            try
            {
                dbConnect.SetData(student);
            } catch (SQLException e)
            {
                InfoBox.display("Info","Error in Data Sent");
                e.printStackTrace();
            }
        }
        InfoBox.display("Info","Changes successful Saved");
    }

    @FXML
    public void Delete()
    {
        dbConnect.DeleteBelow3();
        try
        {
            Load();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        InfoBox.display("Info","Students with grades of 3 or lower successfully deleted\n");
        
    }

    private void Update()
    {
        tableView.refresh();
        //   tableView.sort();
        dbConnect.UpdateID();
        list = tableView.getItems();
        if (autoUpdate.isSelected())
        {
            for (int i = 1; i <= list.size(); i++)
            {
                try
                {
                    dbConnect.UpdateData(list.get(i - 1), i);
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void Add()
    {
        if (math_field.getText().isEmpty())
            math_field.setText("0");
        if (java_field.getText().isEmpty())
            java_field.setText("0");
        if (economy_field.getText().isEmpty())
            economy_field.setText("0");
        if (physics_field.getText().isEmpty())
            physics_field.setText("0");
        tableView.getItems().add(new Student(name_field.getText(), Integer.parseInt(math_field.getText()),
                Integer.parseInt(java_field.getText()), Integer.parseInt(physics_field.getText()),
                Integer.parseInt(economy_field.getText())));
        Save();
        InfoBox.display("Info","New Student Added");
    }
@FXML
public void Close()
{
    Main.stage.close();
}
    private void CheckType(TextField textField)
    {
        for (int i = 0; i < textField.getLength(); i++)
        {
            if (!Character.isDigit(textField.getText().charAt(i)))
            {
                textField.setText("");
            }
        }
    }
}
