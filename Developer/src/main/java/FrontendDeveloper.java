public class FrontendDeveloper extends Developer implements IFrontendDeveloper{


    public FrontendDeveloper(String name) {
        super(name, "frontend developer");
    }

    @Override
    public void writeFrontendCode() {
        System.out.println("writing some badass frontend code...");
    }
    public void developGUI() {
        System.out.println("developing a GUI...");
    }

}
