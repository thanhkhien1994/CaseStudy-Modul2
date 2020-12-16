
package file;

import admin.Admin;

import java.io.*;

public class FileAdmin {
    public void writeFileAdmin(Admin o) throws IOException {
        FileOutputStream f = null;
        ObjectOutputStream oos = null;
        try {
            f = new FileOutputStream("admin.dat");
            oos = new ObjectOutputStream(f);
            oos.writeObject(o);
        } catch (IOException e) {
            System.out.println("Error Write file");
        } finally {
            oos.writeObject(o);
            f.close();
        }
    }
    public Admin readFileAdmin() throws IOException {
        Admin o = null;
        FileInputStream f = null;
        ObjectInputStream ois = null;
        try {
            f = new FileInputStream("admin.dat");
            ois = new ObjectInputStream(f);
            o = (Admin) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }finally {
//            ois.close();
            f.close();
        }
        return o;
    }
}
