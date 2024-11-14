//класс, наследованный от Exception
//используется при отлавливании исключений, связанных
//с неверными датами рождения
public class InvalidDateException extends Exception{
    //конструктор принимает сообщение и передает Exception
    public InvalidDateException(String message){
        super(message);
    }
}
