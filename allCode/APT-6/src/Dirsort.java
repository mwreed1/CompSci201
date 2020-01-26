import java.util.ArrayList;
import java.util.Comparator;

public class Dirsort {
    int size;
    String[] folders;
    public Dirsort(){}
    public int getSize(){
        return size;
    }
    public String[] getFolders(){
        return folders;
    }
    public String getFirst(){
        return folders[0];
    }
    public String getSecond(){
        if(folders.length > 1) return folders[1];
        else{return null;}
    }
    public String getThird(){
        if(folders.length > 2) return folders[2];
        else{return null;}
    }
    public String[] sort(String[] dirs) {
        ArrayList<Dirsort> list = new ArrayList<Dirsort>();
        for(String dir : dirs){
            if(!dir.equals("/")) {
                dir = dir.substring(1);
                String[] dirList = dir.split("/");
                Dirsort direct = new Dirsort();
                direct.size = dirList.length;
                direct.folders = dirList;
                list.add(direct);
            }
            else{
                String[] dirList = dir.split("");
                Dirsort direct = new Dirsort();
                direct.size = 1;
                direct.folders = dirList;
                list.add(direct);
            }
        }
        //if(list.size() > 2) list.sort(Comparator.comparing(Dirsort::getThird));
        //if(list.size() > 1) list.sort(Comparator.comparing(Dirsort::getSecond));
        list.sort(Comparator.comparing(Dirsort::getFirst));
        list.sort(Comparator.comparing(Dirsort::getSize));
        String[] ret = new String[list.size()];
        int i = 0;
        for(Dirsort m : list){
            String w = "/";
            for(int j = 0; j<m.folders.length;j++) {
                if(!m.folders[j].equals("/")) w += m.folders[j] + "/";
            }
            ret[i] = w;
            i++;
        }
        return ret;
    }
}