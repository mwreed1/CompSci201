public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String accessList = "";
        for(int i = 0; i < rights.length ; i++){
            if(rights[i] >= minPermission){
                accessList = accessList + "A";
            }
            else {
                accessList = accessList + "D";
            }
        }
        return accessList;
    }
}