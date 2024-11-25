import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next;
    Node prev;
    //노드 안에 데이터와 다음 노드, 이전 노드를 가르키는 포인터
    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int length = 0;
    //처음 노드를 가르키는 head, 마지막을 가르키는 tail
    //더블 링크드 리스트 생성
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    //새로운 노드 추가
    public void append(int data){
        Node newNode = new Node(data);
        length++;
        //리스트에 아무 것도 없을 때 head 와 tail을 새로운 노드로 설정
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            //리스트에 데이터가 존재할 때, 리스트의 마지막 다음에 노드를 연결
            tail.next = newNode;
            //새로운 노드의 이전 포인터를 리스트의 마지막을 가르키도록 설정
            newNode.prev = tail;
            //tail 포인터가 새로운 노드를 가르키도록 변경
            tail = newNode;
        }
    }
    //특정 index에 노드 삽입
    public void insert(int data, int index){
        Node newNode = new Node(data);
        Node currentNode = head;
        length++;
        //삽입이 중간이라면, head가 삽입할 노드, 삽입할 노드의 다음이 첫 노드, 첫 노드의 이전이 삽입할 노드
        if (index == 0){
            head = newNode;
            newNode.next = currentNode;
            currentNode.prev = newNode;
        } else {
            //삽입할 index까지 가기
            for(int i = 0; i < index && currentNode != null; i++){
                currentNode = currentNode.next;
            }
            if (currentNode == null){
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                //삽입할 노드를 이전 노드와 연결하기
                currentNode.prev.next = newNode;
                newNode.prev = currentNode.prev;
                //삽입할 노드를 현재 노드와 연결하기
                currentNode.prev = newNode;
                newNode.next = currentNode;
            }

        }
    }


    public void display() {
        Node currentNode = head;
        while (currentNode != null){
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public int findSpace(int data){
        int count = 0;
        Node newNode = new Node(data);
        Node currentNode = head;
        while(currentNode != null){
            //만약 리스트 안 데이터가 더 크다면 중간에 삽입
            if (currentNode.data > newNode.data){
                insert(data, count);
                break;
            }
            count++;
            currentNode = currentNode.next;
        }
        //새로운 노드가 제일 큰 경우 맨뒤에 놓고 움직이는 사람이 없음
        if (currentNode == null) {
            insert(data, length+1);
            return 0;
        } else {
            return length - count - 1;
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //첫번째 P를 받아서 반복
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            //움직인 횟수를 더하는 sum
            int sum = 0;
            //stringTokenizer로 하나씩 받음, 첫 번째는 날림
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            tokenizer.nextToken();
            //새로운 더블링크드 리스트 생성
            DoubleLinkedList DLL = new DoubleLinkedList();

            int height = 0;
            for (int j = 0; j < 20; j++) {
                height = Integer.parseInt(tokenizer.nextToken());
                if ( j == 0) {
                    DLL.append(height);
                } else {
                    sum += DLL.findSpace(height);
                }
            }
            sb.append((i + 1) + " " + sum + "\n");
        }
        br.close();
        System.out.println(sb.toString());
    }
}