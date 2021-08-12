/*
 * Author: Bregovic Dominik
 * every user is extending from this class in order to get the interface and in future also functions and more attributes
 * Last change: 12.08.2021
 */
public abstract class User implements SaveAndDelete {
    int id;
    String name;
    String password;
}
