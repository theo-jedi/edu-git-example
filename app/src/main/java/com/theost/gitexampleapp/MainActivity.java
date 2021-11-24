package com.theost.gitexampleapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // My editions

        findViewById(R.id.button).setOnClickListener(view -> showToast());
    }

    private void showToast() {
        Toast.makeText(this, R.string.text, Toast.LENGTH_SHORT).show();
    }

}


    Реализовать иерархию классов "Геометрические фигуры". Код программы должен содержать следующее:

//        Базовый класс Figure с дробными полями x, y - координаты фигуры и абстрактными методами getArea() и getPerimeter() - вычисление площади и периметра соответственно. Так же необходимо реализовать конструктор Figure(float x, float y).
//
//        Два класса-наследника Figure. Класс Rectangle (прямоугольник) с дробными полями height (высота) и width (ширина) и класс Circle с дробным полем radius (радиус). Необходимо реализовать конструкторы классов-наследников Rectangle(float x, float y, float height, float width) и Circle(float x, float y, float radius), а также переопределить функции getArea() и getPerimeter() базового класса таким образом, чтобы при выполнении кода:

abstract class Figure {
    public float x;
    public float y;

    public Figure(float x, float y) {
        this.x = x;
        this.y = y;
    }

    abstract float getArea();

    abstract float getPerimeter();
}

class Rectangle extends Figure implements Moveable{
    public float height;
    public float width;

    public Rectangle(float x, float y, float height, float width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    public float getArea() {
        return height * width;
    }

    @Override
    public float getPerimeter() {
        return (height + width) * 2;
    }

    @Override
    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void resize(float koeff) {
        this.height *= koeff;
        this.width *= koeff;
    }

    public void getCenter() {
        this.x += x / 2;
        this.y += y / 2;
    }

    @Override
    public String toString() {
        return ("Rectangle" + "\n" + "Center: " + "(" + (x + height / 2) + ", " + (y + width / 2) + ")" + "\n" + "Height: " + height + "\n" + "Width: " + width);
    }
}

class Circle extends Figure implements Moveable {
    public float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.sqrt(radius));
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void resize(float koef) {
        this.radius *= koef;
    }

    @Override
    public String toString() {
        return ("Circle" + "\n" + "Center: " + "(" + x + ", " + y + ")" + "\n" + "Radius: " + radius);
    }
}

interface Moveable {
    void move(float dx, float dy);
    void resize(float koef);
}
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 1);
        Rectangle rectangle = new Rectangle(10, 10, 1, 1);
        System.out.println(circle);
        System.out.println();
        System.out.println(rectangle);
    }
}
