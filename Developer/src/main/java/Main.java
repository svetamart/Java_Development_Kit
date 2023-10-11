import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Developer frontender1 = new FrontendDeveloper("John");
        Developer frontender2 = new FrontendDeveloper("Chris");
        Developer backender1 = new BackendDeveloper("Amy");
        Developer backender2 = new BackendDeveloper("Harry");
        Developer fullstackdev = new FullStackDeveloper("Mary");

        List<Developer> team = new ArrayList<>();
        team.add(frontender1);
        team.add(frontender2);
        team.add(backender1);
        team.add(backender2);
        team.add(fullstackdev);

        System.out.println("Let's see who on our team has the skills to develop a GUI:");
        for (Developer dev : team) {
            if (dev instanceof FrontendDeveloper) {
                System.out.print(dev.getName() + " is ");
                ((FrontendDeveloper) dev).developGUI();
            } else if (dev instanceof FullStackDeveloper) {
                System.out.println(dev.getName() + " is a " + dev.getPosition() +
                        " but they are very busy at the moment doing some other important developer stuff.");
            }
            else {
                System.out.println(dev.getName() + " cannot develop GUIs, they are not a Frontend Developer. Position: "
                        + dev.getPosition() + ".");
            }
        }
    }
}

