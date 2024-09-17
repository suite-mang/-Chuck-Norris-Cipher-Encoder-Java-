package chucknorris;



enum UserState{
         EXIT,START

}

class Converter{
        static UserState state;


        public void setMainState() {
                state = UserState.START;
                System.out.println("Please input operation (encode/decode/exit):");
        }
        public boolean isWorking() {
                return state == UserState.EXIT;
        }

       public void action( String input){

                switch(input.toLowerCase()){
                        case "encode":
                                ChuckNorrisUnaryCode chuckNorrisUnaryCode =new ChuckNorrisUnaryCode("00 ","0 ");
                                chuckNorrisUnaryCode.encode();
                                setMainState();
                                break;
                        case "decode":
                                ChuckNorrisToText chuckNorrisToText = new ChuckNorrisToText();
                                chuckNorrisToText .decode();
                                setMainState();
                                break;

                        case "exit":
                                state= UserState.EXIT;
                                System.out.println("Bye!");
                                break;

                        default:
                                System.out.println("There is no '" + input + "' operation\n");
                                setMainState();
                                break;


                }

        }




}

