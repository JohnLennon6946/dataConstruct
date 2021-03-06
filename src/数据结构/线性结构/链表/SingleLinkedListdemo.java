package 数据结构.线性结构.链表;

public class SingleLinkedListdemo {
    public static void main(String[] args) {
        //测试
        //先创建几个节点
        HeroNode hero1= new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2= new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3= new HeroNode(3, "吴用", "智多星");
        HeroNode hero4= new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        SingleLinkedList s1=new SingleLinkedList();
//        s1.add(hero1);
//        s1.add(hero2);
//        s1.add(hero3);
//        s1.add(hero4);

        //按照编号添加
        s1.addByorder(hero1);
        s1.addByorder(hero4);
        s1.addByorder(hero2);
        s1.addByorder(hero3);

        //测试修改节点
        HeroNode newHeroNode=new HeroNode(2,"小张","张天罡");
        s1.update(newHeroNode);
        s1.list();
    }
}
//定义一个SingleLinkedList来管理英雄
class SingleLinkedList{
    //先初始化一个头节点,头节点不能动且不存数据
    private  HeroNode head=new HeroNode(0,"","");

    //添加节点到单向链表
    public void add(HeroNode heroNode){
        //当不考虑编号的顺序时
        //找到当前链表的最后节点，将最后节点的next域指向新的节点
        //因为head不能动，所以我们需要一个辅助指针
        HeroNode temp=head;
        //找到链表的最后
        while (true){
            //找到链表的最后
            if (temp.next==null){
                break;
            }
            //如果没有找到最后,temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向链表最后
        temp.next=heroNode;
    }
    //修改节点的信息
    public void update(HeroNode newHeroNode){
        //根据newHeroNode.no来修改
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no
        HeroNode temp=head.next;
        boolean flag=false; //表示是否找到该节点
        while (true){
            if(temp==null){
                break; //如果temp为空表示链表遍历结束
            }
            if (temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){ //根据flag判断是否找到该节点
//            newHeroNode.next=temp.next;
//            temp.next=newHeroNode;
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            System.out.printf("没有找到编号为%d的节点",newHeroNode.no);
        }
    }
    //第二种添加的方式，按照no顺序添加
    public void addByorder(HeroNode heroNode){
        //因为头节点不能动，所以仍然使用辅助指针
        //因为是单链表，因此找的temp位于添加位置的前一个结点
        HeroNode temp=head;
        boolean flag=false;//表示英雄添加的编号是否存在
        while (true){
            if(temp.next==null){
                //temp已经在链表最后
                break;
            }
            if(temp.next.no>heroNode.no){  //位置找到了，就在temp后面插入
                break;
            }else if(temp.next.no==heroNode.no){
                //说明希望添加的编号已经存在
                flag=true;
                break;
            }
            temp=temp.next; //遍历
        }
        //判断flag
        if(flag==true){
            //编号存在，不能添加
            System.out.printf("该编号%d在链表中已经存在",heroNode.no);
        }else {
            //加入
            heroNode.next=temp.next;
            temp.next=heroNode;

        }
    }

    //显示链表，也需要通过一个辅助变量遍历
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while (true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移
            temp=temp.next;
        }
    }
}


//定义一个heronode，每一个heronode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int No,String name,String nickname){
        this.no=No;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
