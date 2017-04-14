import java.io.File;

/**
 * Created by IVAN_J4U on 4/15/2017.
 */
public class FileRenaming {

    private static final String parentPath = "D:/Comic/Injustice - Gods Among Us/";
    private static final String typeFile = ".rar";

    public static void main(String[] args) {
        try {
            File path = new File(parentPath);
            File[] folder = path.listFiles();
            for (File file : folder) {
                if (file.isDirectory()) {
                    /**
                     * Read file child (just once)
                     */
                    File[] files = file.listFiles();
                    for (File childFile : files) {
                        if (childFile.isDirectory())
                            continue;
                        renameFile(childFile);
                    }
                    continue;
                }
                renameFile(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void renameFile(File file) throws Exception {
        //Renaming File
        String newName = file.getName().substring(0, (file.getName().length() - 4))+ typeFile;
        File newFile = new File(file.getParent() + "/" + newName);
        file.renameTo(newFile);
        System.out.println(newName);
    }
}
