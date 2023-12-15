package Belebey.back_3_lab.Exceptions;

public class ExistException extends RuntimeException{
    public ExistException (String message){
        super(message);
    }
    public static final String TASK_EXIST = "Такая задача уже существует";
    public static final String TASK_NOT_EXIST = "Такая задача не существует";
}
