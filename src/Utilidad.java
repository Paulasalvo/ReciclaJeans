public class Utilidad {
    public void limpiezaPantalla() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    public void tiempoEspera(String mensaje, int sleepTimer) {
        System.out.print("**" + mensaje + "**");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(sleepTimer);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

}
