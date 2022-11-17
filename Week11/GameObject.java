package Week11;

public interface GameObject {
    public abstract void draw(); 
    // {
    //     System.out.println("Drawing a GameObject");
    // }

    public static void main(String[] args) {
        GameObject[] objects = new GameObject[3];
        objects[0] = new Rectangle();
        objects[1] = new Circle();
        objects[2] = new Triangle();
        for(GameObject object : objects) {
            object.draw();
        }
    }
}

class Rectangle implements GameObject {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Circle implements GameObject {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Triangle implements GameObject {
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}



