/*
Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
все его методы.
 */

public class FullStackDeveloper extends Developer implements IBackendDeveloper, IFrontendDeveloper{
    public FullStackDeveloper(String name) {
        super(name, "fullstack developer");
    }

    @Override
    public void writeBackendCode() {
        System.out.println("writing server-side code...");
    }

    @Override
    public void writeFrontendCode() {
        System.out.println("writing frontend code...");
    }

    @Override
    void drinkCoffee() {
        System.out.println("Drinking coffee...");
    }
}
