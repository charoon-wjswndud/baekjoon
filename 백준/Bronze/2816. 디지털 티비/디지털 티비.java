import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static ArrayList<Channel> channerList = new ArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			channerList.add(new Channel(br.readLine().toString()));
		}
		RemoteControl remocon = new RemoteControl();
		RemoteControl.setArrow(channerList.get(0));
		setKBS1(channerList, remocon);//KBS1 이동
		setKBS2(channerList, remocon);
	}
	private static void setKBS1(ArrayList<Channel> channers, RemoteControl remocon) {
		while (!RemoteControl.getArrow().getName().equals("KBS1")) {
			remocon.button1(channers);
		}
		while(channers.indexOf(RemoteControl.getArrow()) != 0) {
			remocon.button4(channers);
		}
	}
	private static void setKBS2(ArrayList<Channel> channers, RemoteControl remocon) {
		while (!RemoteControl.getArrow().getName().equals("KBS2")) {
			remocon.button1(channers);
		}
		while(channers.indexOf(RemoteControl.getArrow()) != 1) {
			remocon.button4(channers);
		}
	}
}

class Channel{
	private String name;
	
	public Channel(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class RemoteControl{
	private static Channel arrow = null;
	void button1(ArrayList<Channel> channers) {	//화살표를 한 칸 아래로 내린다. 
		System.out.print(1);
		setArrow(channers.get(channers.indexOf(arrow)+1));
	};	
	void button2(ArrayList<Channel> channers) {	//화살표를 위로 한 칸 올린다.
		System.out.print(2);
		setArrow(channers.get(channers.indexOf(arrow)-1));
	};
	void button3(ArrayList<Channel> channers) {	//현재 선택한 채널을 한 칸 아래로 내린다.
		System.out.print(3);
		Collections.swap(channers, channers.indexOf(arrow),channers.indexOf(arrow)+1);
	};
	void button4(ArrayList<Channel> channers) {	//현재 선택한 채널을 위로 한 칸 올린다.
		System.out.print(4);
		Collections.swap(channers, channers.indexOf(arrow),channers.indexOf(arrow)-1);
	};
	
	public static Channel getArrow() {
		return arrow;
	}
	public static void setArrow(Channel arrow) {
		RemoteControl.arrow = arrow;
	};
	
}