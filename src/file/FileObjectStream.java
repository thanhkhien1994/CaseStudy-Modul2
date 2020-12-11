
package file;

import admin.Admin;
import program.menu.ManageAdmin;

import java.io.*;

public class FileObjectStream {
    public void writeFileAdmin(Admin o){

        try {
            FileOutputStream f = new FileOutputStream("admin.dat");
            ObjectOutputStream oStream = new ObjectOutputStream(f);
            oStream.writeObject(o);
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }
    public Admin readFileAdmin(){
        Admin o = null;
        try {
            FileInputStream f = new FileInputStream("admin.dat");
            ObjectInputStream inStream = new ObjectInputStream(f);
            o = (Admin) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
        return o;
    }
}
