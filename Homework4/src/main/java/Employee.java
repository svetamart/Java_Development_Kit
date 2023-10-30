class Employee {

    private static int nextEmployeeId = 1;
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(String phoneNumber, String name, int experience) {
        this.employeeId = nextEmployeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getInfo() {
        return "Employee ID: " + getEmployeeId() +
                "\nName: " + getName() +
                "\nPhone number: " + getPhoneNumber() +
                "\nExperience: " + getExperience() + " years\n";
    }
}
