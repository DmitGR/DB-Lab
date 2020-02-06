package Logic;

/**
 * Created by SmiLeX on 22.11.2017.
 */
public class Student
{
    private String name;
    private int math_grade;
    private int java_grade;
    private int physics_grade;
    private int economy_grade;
    private double average_grade;
    private int math_hours;
    private int java_hours;
    private int economy_hours;
    private int physics_hours;
    private final double NUMBER_OF_SUBJECTS = 4;



    public Student(String name, int math_grade, int math_hours, int java_grade,int java_hours, int physics_grade,int physics_hours, int economy_grade, int economy_hours)
    {
        this.name = name;
        this.math_grade = math_grade;
        this.java_grade = java_grade;
        this.physics_grade = physics_grade;
        this.economy_grade = economy_grade;
        this.math_hours=math_hours;
        this.java_hours=java_hours;
        this.economy_hours=economy_hours;
        this.physics_hours=physics_hours;
        this.average_grade = (math_grade + java_grade + physics_grade + economy_grade) / NUMBER_OF_SUBJECTS;
    }
    public Student(String name, int math_grade,  int java_grade, int physics_grade, int economy_grade)
    {
        this.name = name;
        this.math_grade = math_grade;
        this.java_grade = java_grade;
        this.physics_grade = physics_grade;
        this.economy_grade = economy_grade;
        this.average_grade = (math_grade + java_grade + physics_grade + economy_grade) / NUMBER_OF_SUBJECTS;
    }

    private void UpdateAvgGrade()
    {
        this.average_grade = (math_grade + java_grade + physics_grade + economy_grade) / NUMBER_OF_SUBJECTS;
    }

    //region Properties
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMath_grade()
    {
        return math_grade;
    }

    public void setMath_grade(int math_grade)
    {
        this.math_grade = math_grade;
        UpdateAvgGrade();
    }

    public int getJava_grade()
    {
        return java_grade;
    }

    public void setJava_grade(int java_grade)
    {
        this.java_grade = java_grade;
        UpdateAvgGrade();
    }

    public int getPhysics_grade()
    {
        return physics_grade;
    }

    public void setPhysics_grade(int physic_grade)
    {
        this.physics_grade = physic_grade;
        UpdateAvgGrade();
    }

    public int getEconomy_grade()
    {
        return economy_grade;
    }

    public void setEconomy_grade(int economy_grade)
    {
        this.economy_grade = economy_grade;
        UpdateAvgGrade();
    }


    public int getMath_hours()
    {
        return math_hours;
    }

    public void setMath_hours(int math_hours)
    {
        this.math_hours = math_hours;
    }

    public int getJava_hours()
    {
        return java_hours;
    }

    public void setJava_hours(int java_hours)
    {
        this.java_hours = java_hours;
    }

    public int getEconomy_hours()
    {
        return economy_hours;
    }

    public void setEconomy_hours(int economy_hours)
    {
        this.economy_hours = economy_hours;
    }

    public int getPhysics_hours()
    {
        return physics_hours;
    }

    public void setPhysics_hours(int physics_hours)
    {
        this.physics_hours = physics_hours;
    }

    public double getAverage_grade()
    {
        return average_grade;
    }
    //endregion
}
