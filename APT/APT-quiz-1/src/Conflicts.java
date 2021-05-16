import java.util.*;

public class Conflicts {
    public String[] conflict(String[] info){
        ArrayList<String> rooms = new ArrayList<String>();
        ArrayList<String> times = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        for(String difClass : info){
            String[] classInfo = difClass.split(":");
            String room = classInfo[1];
            String time = classInfo[2];
            rooms.add(room);
            times.add(time);
        }
        for(int i = 0; i < info.length; i++){
            for(int k = 0; k < info.length; k++){
                if(!(i == k) && rooms.get(i).equals(rooms.get(k))) {
                    String[] meetingTimes = times.get(i).split(",");
                    ArrayList<String> otherTimes = new ArrayList<String>(Arrays.asList(times.get(k).split(",")));
                    for(int j = 0; j < meetingTimes.length; j++){
                        if(otherTimes.contains(meetingTimes[j]) && !(result.contains(rooms.get(i)))){
                            result.add(rooms.get(i));
                        }
                    }
                }
                }
            }
        Collections.reverse(result);
        String[] ret = result.toArray(new String[0]);
        return ret;
    }
}