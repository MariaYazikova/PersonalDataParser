//класс, наследованный от Exception
//используется при отлавливании исключений, связанных
//с неверным форматом пользовательских данных
class InvalidInputException extends Exception{
    //конструктор принимает сообщение и передает Exception
    public InvalidInputException(String message){
        super(message);
    }
}
