public class Param {
    public String name;
    public String type;
    public String desc;
    public int offset;
    public long value;

    public Param(String name, String type, String desc, int offset) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.offset = offset;
        value = 0;

    }

    public void println() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Description: " + desc);
        System.out.println("Offset: " + offset);
    }
}
