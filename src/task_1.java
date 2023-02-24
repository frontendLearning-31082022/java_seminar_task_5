import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class task_1 {

    public static void main(String[] args) {
        PhoneTable phoneTable=new PhoneTable();

        String idSetted= phoneTable.addNewUser("Иван Иванов","88007");
        String personTheSameName=phoneTable.addNewUser("Иван Иванов","88056");

        phoneTable.addPhoneNumber(idSetted,"660504356");

        phoneTable.addNewUser("Сергей Иванов","88007");

        new String();


    }

    static class PhoneTable{

        public HashMap<CompositeKey,HashMap<String,Object>>mainStruct=new HashMap();

        int id=0;
        PhoneTable(){

        }

        String addNewUser(String name, String phone){
            Integer keyInBase=containsKey(name);
            CompositeKey key=new CompositeKey(name,(keyInBase==null)?0:++keyInBase);


            HashMap<String,Object>fields=new HashMap<>();
            fields.put("phone",new ArrayList<>(Arrays.asList(phone)));

            mainStruct.put(key,fields);
            return key.toString();
        }


        Integer containsKey(String name){
            try {
                Integer max= mainStruct.keySet().stream().filter(s->s.toString().matches(name+"\\d*")).map(s->s.duplicateID).mapToInt(x->x).max().getAsInt();
                return max;
            }catch (NoSuchElementException f){
                return null;
            }
        }

        private void addPhoneNumber(String ident, String phoneNumber) {
            String name=ident.replaceAll("\\d*$","");
            int id= Integer.parseInt(ident.replaceAll("\\D",""));

            ArrayList<String> phonesList= (ArrayList<String>) mainStruct.get(new CompositeKey(name,id)).get("phone");
            phonesList.add(phoneNumber);
        }

        public static class CompositeKey{
            private String nameKey;
            private int duplicateID;


            public CompositeKey(String key,int id) {
                this.nameKey=key;
                this.duplicateID=id;
            }

            public CompositeKey(){

            }

            @Override
            public boolean equals(Object obj){
                return   (nameKey+duplicateID).equals(obj.toString());

            }

            @Override
            public String toString(){
                return nameKey+duplicateID;
            }

            @Override
            public int hashCode(){
                return (nameKey + duplicateID).hashCode();
            }

        }



    }
}
