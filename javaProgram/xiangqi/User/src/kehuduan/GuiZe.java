package kehuduan;

public class GuiZe {
	QiZi[][] qiZi;
	boolean canMove=false;
	int i;
	int j;
	public GuiZe(QiZi[][] qiZi){
		this.qiZi=qiZi;
	}
	public boolean canMove(int startI,int startJ,int endI,int endJ,String name){
		int maxI=-1;
		int maxJ=-1;
		int minI=-1;
		int minJ=-1;
		canMove=true;
		//�����С��ϵ�Ա��Ժ����
		if(startI>=endI){
			maxI=startI;
			minI=endI;
		}else if(startI<endI){
			maxI=endI;
			minI=startI;
		}

		if(startJ>=endJ){
			maxJ=startJ;
			minJ=endJ;
		}else{
			maxJ=endJ;
			minJ=startJ;
		}

		//�õ����ӵ����ӣ��������ӵ��¼�
		if(name.equals("܇")){
			this.ju(maxI, minI, maxJ, minJ);
		}
		if(name.equals("�R")){
			this.ma(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")||name.equals("��")){
			this.xiang(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")||name.equals("ʿ")){
			this.shi(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")||name.equals("˧")){
			this.jiang(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")){
			this.pao(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")){
			this.bing(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("��")){
			this.zu(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}

		return canMove;
	}


	public void ju(int maxI,int minI,int maxJ,int minJ){
		if(maxI==minI){
			for(i=1;i<(maxJ-minJ);i++){
				if(qiZi[maxI][minJ+i]!=null){
					canMove=false;
					break;
				}
			}
		}
		else if(maxJ==minJ){
			for(j=1;j<(maxI-minI);j++){
				if(qiZi[minI+j][maxJ]!=null){
					canMove=false;
					break;
				}
			}
		}
		else if(maxI!=minI&&maxJ!=minJ){
			canMove=false;
		}
	}

	public void ma(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		int a=maxI-minI;
		int b=maxJ-minJ;
		//�ж�ѹ�R�Ȳ����ߵ����
		if(a==2&&b==1){//�����
			if(endI>startI){//��������
				if(qiZi[startI+1][startJ]!=null){
					canMove=false;
				}
			}else if(endI<startI){//��������
				if(qiZi[startI-1][startJ]!=null){
					canMove=false;
				}
			}
		}else if(a==1&&b==2){//������
			if(endJ<startJ){//��������
				if(qiZi[startI][startJ-1]!=null){
					canMove=false;
				}
			}else if(endJ>startJ){//��������
				if(qiZi[startI][startJ+1]!=null){
					canMove=false;
				}
			}
		}else{
			canMove=false;
		}
	}

	public void xiang(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){//"��"�Ĵ���
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2){
			if(startJ<=4){//������Ϸ�����
				if(endJ>4){
					canMove=false;
				}else if(qiZi[(minI+maxI)/2][(minJ+maxJ)/2]!=null){
					canMove=false;
				}
			}else if(startJ>=5){//������·�����
				if(endJ<5){
					canMove=false;
				}else if(qiZi[(minI+maxI)/2][(minJ+maxJ)/2]!=null){
					canMove=false;
				}
			}
		}else{
			canMove=false;
		}
	}

	public void shi(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==1&&b==1){
			if(startJ<=2||startJ>=7){
				if(endI>5||endI<3){
					canMove=false;
				}else if(endJ>2&&endJ<7){
					canMove=false;
				}
			}else{
				canMove=false;
			}
		}else{
			canMove=false;
		}
	}
	public void jiang(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		int a=maxI-minI;
		int b=maxJ-minJ;
		if((a==0&&b==1)||(a==1&&b==0)){
			if(startJ<=2||startJ>=7){
				if(endI>5||endI<3){
					canMove=false;
				}else if(endJ>2&&endJ<7){
					canMove=false;
				}
			}else{
				canMove=false;
			}
		}else{
			canMove=false;
		}
	}
	public void pao(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		if(maxI==minI){//������
			if(qiZi[endI][endJ]!=null){//�յ�������
				int count=0;
				for(j=1;j<maxJ-minJ;j++){
					if(qiZi[maxI][minJ+j]!=null){
						count++;
					}
				}
				if(count!=1){
					canMove=false;
				}
			}else if(qiZi[endI][endJ]==null){//�յ�û������
				for(j=1;j<maxJ-minJ;j++){
					if(qiZi[maxI][minJ+j]!=null){
						canMove=false;
						break;
					}
				}
			}
		}else if(maxJ==minJ){//������
			if(qiZi[endI][endJ]!=null){//�յ�������
				int count=0;
				for(i=1;i<maxI-minI;i++){
					if(qiZi[minI+i][maxJ]!=null){
						count++;
					}
				}
				if(count!=1){
					canMove=false;
				}
			}else if(qiZi[endI][endJ]==null){//�յ�û������
				for(i=1;i<maxI-minI;i++){
					if(qiZi[minI+i][maxJ]!=null){
						canMove=false;
						break;
					}
				}
			}
		}else{
			canMove=false;
		}
	}
	public void bing(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		if(startJ<5)//�����û�й���
		{
			if(startI!=endI)//���������ǰ��
			{
				canMove=false;//��������
			}
			if(endJ-startJ!=1)//����ߵĲ���һ��
			{
				canMove=false;//��������
			}
		}
		else
		{//����Ѿ�����
			if(startI==endI)
			{//����ߵ�������
				if(endJ-startJ!=1)//����ߵĲ���һ��
				{
					canMove=false;//��������
				}
			}
			else if(startJ==endJ)
			{//����ߵ��Ǻ���
				if(maxI-minI!=1)
				{//����ߵĲ���һ��
					canMove=false;//��������
				}
			}
			else if(startI!=endI&&startJ!=endJ)
			{//����ߵļȲ������ߣ�Ҳ���Ǻ��ߣ��򲻿�����
				canMove=false;
			}
		}
	}
	public void zu(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		if(startJ>4)
		{//�����û�й���
			if(startI!=endI)
			{//���������ǰ��
				canMove=false;//��������
			}
			if(endJ-startJ!=-1)//����ߵĲ���һ��
			{
				canMove=false;
			}
		}
		else
		{//����Ѿ�����
			if(startI==endI)
			{//����ߵ�������
				if(endJ-startJ!=-1)
				{//����ߵĲ���һ��
					canMove=false;//��������
				}
			}
			else if(startJ==endJ)
			{//����ߵ��Ǻ���
				if(maxI-minI!=1)
				{//����ߵĲ���һ��
					canMove=false;//��������
				}
			}
			else if(startI!=endI&&startJ!=endJ)
			{//����ߵļȲ������ߣ�Ҳ���Ǻ��ߣ��򲻿�����
				canMove=false;
			}
		}
	}
}
