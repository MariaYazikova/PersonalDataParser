public class Gender {
    private String patronymic;

    //конструктор без параметров
    public Gender(){
        this.patronymic = "Петрович";
    }
    //конструктор с параметрами
    public Gender(String patronymic){
        this.patronymic = patronymic;
    }

    //метод идентификации пола по окончанию отчества
    public String Identification(){
        String end = this.patronymic.substring(this.patronymic.length()-2);
        if (end.equals("на")){
            return "женский";
        }
        else if (end.equals("ич")){
            return "мужской";
        }
        else{
            return "определить не удалось"; //на случай если отчество не славянское
        }
    }

    //создание строки нужного формата
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Пол: ").append(Identification());
        return str.toString();
    }
}
