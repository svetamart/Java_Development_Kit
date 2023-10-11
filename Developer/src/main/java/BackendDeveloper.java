public class BackendDeveloper extends Developer implements IBackendDeveloper{


    public BackendDeveloper(String name) {
        super(name, "backend developer");
    }

    @Override
    public void writeBackendCode() {
        System.out.println("writing some badass server-side code...");
    }
}
