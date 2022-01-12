package ThirdLab.Abstracts;

public abstract class Item {

    private final String name;
    private int count;

    public Item(String name, int count) {
        this.name = name;
        if (count <= 0) {
            System.out.println("Неправильно установлено количество предмета. Оно не может быть меньше 1");
            this.count = 1;
        } else {
            this.count = count;
        }
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Предмет %s.", this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return this.name.equals(item.getName());
    }
}
