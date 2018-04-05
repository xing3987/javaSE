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
		//定义大小关系以便以后计算
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

		//得到棋子的名子，各个名子的事件
		if(name.equals("車")){
			this.ju(maxI, minI, maxJ, minJ);
		}
		if(name.equals("馬")){
			this.ma(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("相")||name.equals("象")){
			this.xiang(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("仕")||name.equals("士")){
			this.shi(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("将")||name.equals("帅")){
			this.jiang(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("炮")){
			this.pao(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("兵")){
			this.bing(maxI, minI, maxJ, minJ, startI, startJ, endI, endJ);
		}
		if(name.equals("卒")){
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
		//判断压馬腿不能走的情况
		if(a==2&&b==1){//横的走
			if(endI>startI){//左往右走
				if(qiZi[startI+1][startJ]!=null){
					canMove=false;
				}
			}else if(endI<startI){//右往左走
				if(qiZi[startI-1][startJ]!=null){
					canMove=false;
				}
			}
		}else if(a==1&&b==2){//竖着走
			if(endJ<startJ){//下往上走
				if(qiZi[startI][startJ-1]!=null){
					canMove=false;
				}
			}else if(endJ>startJ){//上往下走
				if(qiZi[startI][startJ+1]!=null){
					canMove=false;
				}
			}
		}else{
			canMove=false;
		}
	}

	public void xiang(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){//"相"的处理
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2){
			if(startJ<=4){//如果是上方的相
				if(endJ>4){
					canMove=false;
				}else if(qiZi[(minI+maxI)/2][(minJ+maxJ)/2]!=null){
					canMove=false;
				}
			}else if(startJ>=5){//如果是下方的象
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
		if(maxI==minI){//竖着走
			if(qiZi[endI][endJ]!=null){//终点有棋子
				int count=0;
				for(j=1;j<maxJ-minJ;j++){
					if(qiZi[maxI][minJ+j]!=null){
						count++;
					}
				}
				if(count!=1){
					canMove=false;
				}
			}else if(qiZi[endI][endJ]==null){//终点没有棋子
				for(j=1;j<maxJ-minJ;j++){
					if(qiZi[maxI][minJ+j]!=null){
						canMove=false;
						break;
					}
				}
			}
		}else if(maxJ==minJ){//横着走
			if(qiZi[endI][endJ]!=null){//终点有棋子
				int count=0;
				for(i=1;i<maxI-minI;i++){
					if(qiZi[minI+i][maxJ]!=null){
						count++;
					}
				}
				if(count!=1){
					canMove=false;
				}
			}else if(qiZi[endI][endJ]==null){//终点没有棋子
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
		if(startJ<5)//如果还没有过河
		{
			if(startI!=endI)//如果不是向前走
			{
				canMove=false;//不可以走
			}
			if(endJ-startJ!=1)//如果走的不是一格
			{
				canMove=false;//不可以走
			}
		}
		else
		{//如果已经过河
			if(startI==endI)
			{//如果走的是竖线
				if(endJ-startJ!=1)//如果走的不是一格
				{
					canMove=false;//不可以走
				}
			}
			else if(startJ==endJ)
			{//如果走的是横线
				if(maxI-minI!=1)
				{//如果走的不是一格
					canMove=false;//不可以走
				}
			}
			else if(startI!=endI&&startJ!=endJ)
			{//如果走的既不是竖线，也不是横线，则不可以走
				canMove=false;
			}
		}
	}
	public void zu(int maxI,int minI,int maxJ,int minJ,int startI,int startJ,int endI,int endJ){
		if(startJ>4)
		{//如果还没有过河
			if(startI!=endI)
			{//如果不是向前走
				canMove=false;//不可以走
			}
			if(endJ-startJ!=-1)//如果走的不是一格
			{
				canMove=false;
			}
		}
		else
		{//如果已经过河
			if(startI==endI)
			{//如果走的是竖线
				if(endJ-startJ!=-1)
				{//如果走的不是一格
					canMove=false;//不可以走
				}
			}
			else if(startJ==endJ)
			{//如果走的是横线
				if(maxI-minI!=1)
				{//如果走的不是一格
					canMove=false;//不可以走
				}
			}
			else if(startI!=endI&&startJ!=endJ)
			{//如果走的既不是竖线，也不是横线，则不可以走
				canMove=false;
			}
		}
	}
}
