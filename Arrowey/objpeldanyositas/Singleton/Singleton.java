package objpeldanyositas;
/*
 * Egyke programtervezési minta
 * 
 * Egy obijektumra korlátozza az osztály létrehozható példányainak a számát
 * 
 * Memóriát sporol, mert nem lesz minden alkalommal létrehozva, amikor kell, csak egyszer és újra és újra lesz használva
 * A globális változókkal szemben gyakran az egykéket részesítik előnyben, mivel:
 * 	Nem szennyezik a névteret szükségtelen változókkal.
 * 	Lehetővé teszik a lusta allokációt és inicializációt, míg a globális változók mindig fogyasztanak erőforrásokat. 
 * Az egyke használható lusta inicializációval. Ekkor a példány csak az osztálymetódus első hívásakor jön létre. 
 * Ha ezt párhuzamos környezetben használják, akkor biztosítani kell, hogy ne legyen race condition, különben 
 * több szál is létrehozhat egy példányt, ami kritikus a rendszer szempontjából, és annak összeomlását 
 * okozhatja
 */
	
public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}