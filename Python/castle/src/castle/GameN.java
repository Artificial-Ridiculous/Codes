package castle;

import java.util.ArrayList;
import java.util.Scanner;

public class GameN {
    public void showWelcome(){
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
    }

    public void showBye(){
        System.out.println("感谢您的光临。再见！");
    }

    public void showHelp(){
        System.out.println("迷路了吗？你可以做的命令有：go bye help如：\tgo east");
    }

    public void showPrompt(RoomN currentRoom){
        System.out.println("现在你在"+ currentRoom);
        System.out.println("出口有： "+ currentRoom.getExits());
    }

    public RoomN createRoom(){
        RoomN outside = new RoomN("城堡外");
        RoomN lobby = new RoomN("大厅");
        RoomN studyroom = new RoomN("书房");
        RoomN bedroom = new RoomN("卧室");
        RoomN pub = new RoomN("小酒馆");

        outside.setExits(lobby,null,null,null);
        lobby.setExits(pub,outside,studyroom,bedroom);
        bedroom.setExits(null,null,lobby,null);
        studyroom.setExits(null,null,null,lobby);
        pub.setExits(null,lobby,null,null);

        RoomN currentRoom = outside;
        return currentRoom;
    }


    public static void main(String[] args){
        int [] a = {1,2,3};
        for (int each : a){
            System.out.println(each);
        }
        String str = new String("abc");
        System.out.println(str);

        ArrayList<Integer> als = new ArrayList<Integer>();
        als.add(99);
        System.out.println(als.size());
        for (int al:als){
            System.out.println(al);
        }
        /*GameN game = new GameN();
        System.out.println("This is lz version");
        System.out.println("-------------------------------------");
        Scanner in = new Scanner(System.in);
        RoomN currentRoom = game.createRoom();
        game.showWelcome();
        game.showPrompt(currentRoom);
        while(true){
            String[] currentInput = in.nextLine().split(" ");
            if (currentInput[0].equals("help")){
                game.showHelp();
                continue;
            }
            else if (currentInput[0].equals("bye")){
                game.showBye();
                break;
            }
            else if (currentInput[0].equals("go")){
                currentRoom = currentRoom.goToNextRoom(currentInput[1]);
                game.showPrompt(currentRoom);
                continue;
            }
            else{
                continue;
            }

        }*/

    }
}
