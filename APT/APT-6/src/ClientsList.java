import java.util.ArrayList;
import java.util.Comparator;

public class ClientsList {
    String first;
    String last;
    public ClientsList(){}
    public String getFirst(){
        return first;
    }
    public String getLast(){
        return last;
    }
    public String[] dataCleanup(String[] names) {
        ArrayList<ClientsList> list= new ArrayList<ClientsList>();
        for(String name : names){
            if(name.indexOf(",") == -1){
                String[] flList = name.split(" ");
                ClientsList person = new ClientsList();
                person.first = flList[0];
                person.last = flList[1];
                list.add(person);

            }
            else{
              String[] lfList = name.split(", ");
                ClientsList person = new ClientsList();
                person.first = lfList[1];
                person.last = lfList[0];
                list.add(person);
            }
        }
        list.sort(Comparator.comparing(ClientsList::getFirst));
        list.sort(Comparator.comparing(ClientsList::getLast));
        String[] ret = new String[list.size()];
        int i = 0;
        for(ClientsList m : list){
            String info = m.first + " " + m.last;
            ret[i] = info;
            i++;
        }
        return ret;
    }
}