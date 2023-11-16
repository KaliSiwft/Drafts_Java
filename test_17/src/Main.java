abstract class Shape {
    public int width; // 几何图形的宽
    public int height; // 几何图形的高
    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public abstract double area();
}
// Rectangle 为矩形类，该类继承 Shape 类，并拥有 Shape 类的属性
class Rectangle extends Shape{
    public Rectangle(int width, int height){
        super(width,height);
    }
    // 定义一个有参构造器
    public double area(){
        return super.height * super.width;
    }
    // 重写抽象方法 area，计算矩形的面积（高*宽），并将计算结果返回

}
// Triangle 为矩形类，该类继承 Shape 类，并拥有 Shape 类的属性
class Triangle extends Shape {
    public Triangle(int width, int height){
        super(width,height);
    }
    // 定义一个有参构造器
    public double area(){
        return 0.5 * super.height * super.width;
    }
    // 重写抽象方法 area，计算三角形的面积（高\*宽/2），并将计算结果返回

}
/********** End **********/
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 4);
        System.out.println("矩形的面积为：" + rectangle.area());
        Triangle triangle = new Triangle(2, 5); // 创建三角形类对象
        System.out.println("三角形的面积为：" + triangle.area());
    }
}
