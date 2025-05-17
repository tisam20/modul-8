public class User {
    private static final int MAX = 30;
    private static final String[] user = new String[MAX];
    private static final String[] pass = new String[MAX];
    private static int size = 0;

    public static void add(String u, String p) throws Exception {
        if(find(u) != -1) throw new Exception("Username sudah ada!");
        if(size == MAX)   throw new Exception("Slot user penuh!");
        user[size] = u;   pass[size] = p;
        size++;
    }
    public static void login(String u, String p) throws Exception {
        int idx = find(u);
        if(idx == -1 || !pass[idx].equals(p))
            throw new Exception("Username / password salah!");
    }
    private static int find(String u){
        for(int i=0;i<size;i++) if(user[i].equals(u)) return i;
        return -1;
    }
}
