package java_reflections.intermediate_reflections.retrieveannotations;
@Author(name = "Author name")
class name{
    public String name;
    name(String name){
        this.name=name;
    }
}
public class exmpleclass {
    public static void main(String[] args) {

        Class<name> obj = name.class;


        if (obj.isAnnotationPresent(Author.class)) {

            Author author = obj.getAnnotation(Author.class);


            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("No Author annotation found.");
        }
    }
}
