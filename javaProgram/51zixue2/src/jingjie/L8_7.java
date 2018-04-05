//���±�Դ���룬��Դ�����磬ѧϰʹ��

package jingjie;
import java.awt.*;   
import java.awt.datatransfer.*;    
import java.awt.event.*;  
import java.io.*;    
import java.util.logging.*;   
import javax.swing.*;  
    
public class L8_7 {  
   // ���±��ľ���ʵ����  
   private static final long serialVersionUID = 1L;  
   private  TextArea content;   
   private  String filePath = "";//����·��Ϊ��  
   Color color=Color.red;  
   Toolkit toolKit = Toolkit.getDefaultToolkit();  
   Clipboard clipboard = toolKit.getSystemClipboard();  
   public L8_7(){  
       //����һ��JFrame���󣻲������������  
       final JFrame jf = new JFrame("�ҵļ��±�");  
       jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
       jf.setBounds(100,100,500,500);  
       jf.setResizable(true);  
       jf.setVisible(true);  
       //�����˵���  
       MenuBar menu = new MenuBar();  
       jf.setMenuBar(menu);  
       //����������ı���  
       content = new TextArea("",50,50,TextArea.SCROLLBARS_VERTICAL_ONLY);  
       jf.add(content);  
       content.setVisible(true);      
       content.requestFocusInWindow();  
       //�˵����������  
       Menu filemenu = new Menu("�ļ���F��");  
       Menu editmenu = new Menu("�༭��E��");  
       Menu formatmenu = new Menu("��ʽ��O��");  
       Menu viewmenu = new Menu("�鿴��V��");  
       Menu helpmenu = new Menu("������H��");  
       menu.add(filemenu);  
       menu.add(editmenu);  
       menu.add(formatmenu);  
       menu.add(viewmenu);  
       menu.add(helpmenu);  
       //�����ļ��˵��ϵĸ����˵����ӵ��˵���  
       MenuItem newitem = new MenuItem("�½���N��");  
       newitem.setShortcut(new MenuShortcut(KeyEvent.VK_N,false));  
       filemenu.add(newitem);  
       MenuItem openitem = new MenuItem("�򿪣�O��");  
       openitem.setShortcut(new MenuShortcut(KeyEvent.VK_O,false));  
       filemenu.add(openitem);  
       MenuItem saveitem = new MenuItem("���棨S��");  
       saveitem.setShortcut(new MenuShortcut(KeyEvent.VK_S,false));  
       filemenu.add(saveitem);  
       MenuItem saveasitem = new MenuItem("���Ϊ��A��");  
       saveasitem.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));  
       filemenu.add(saveasitem);  
       MenuItem setitem = new MenuItem("ҳ�����ã�U��");  
       setitem.setShortcut(new MenuShortcut(KeyEvent.VK_U,false));  
       filemenu.add(setitem);  
       setitem.setEnabled(false);  
       MenuItem printitem = new MenuItem("��ӡ��P��");  
       printitem.setShortcut(new MenuShortcut(KeyEvent.VK_P,false));  
       filemenu.add(printitem);  
       printitem.setEnabled(false);  
       filemenu.addSeparator();  
       MenuItem exititem = new MenuItem("�˳���X��");  
       exititem.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));  
       filemenu.add(exititem);  
       //��Ӽ�������ʵ���ļ��˵��ϵĸ����˵���Ĺ���  
       //�½��˵���Ĺ���ʵ��  
       newitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
               String con = content.getText();  
               if(!con.equals("")){//�ı������ı���Ϊ��  
                   int result = JOptionPane.showConfirmDialog(  
                           null, ("�Ƿ�Ҫ���棿"),("�����ļ�..."),JOptionPane.YES_NO_CANCEL_OPTION);  
                   if(result == JOptionPane.NO_OPTION){//������  
                       content.setText("");  
                   }  
                     
                   else if(result == JOptionPane.CANCEL_OPTION){//ȡ���½�  
                   }  
                     
                   else if(result == JOptionPane.YES_OPTION)//ѡ�񱣴�  
                   {  
                       JFileChooser jfc = new JFileChooser();//����ѡ�񱣴�·�����ļ���  
                       int bcf = jfc.showSaveDialog(jf);  
  
                       if(bcf == JFileChooser.APPROVE_OPTION){  
                                try {  
                                    //�����ļ�  
                                    BufferedWriter bfw = new BufferedWriter(  
                                            new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                                    filePath = jfc.getSelectedFile().getAbsolutePath()+".txt";//��ȡ�ļ������·��  
                                    bfw.write(con);//���ļ�д������  
                                    bfw.flush();  
                                    bfw.close();//�ر������  
                                } catch (IOException ex) {  
                                    Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                                }  
                           new L8_7();//�½��ı��ļ�  
                       }  
                   }  
               }  
           }  
             
       });  
       //�򿪲˵���Ĺ���ʵ��  
        openitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
//          JFileChooser jfile = new JFileChooser();  
//          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt","txt");  
//          jfile.setFileFilter(filter);  
//          jfile.setVisible(true);  
//          int returnval = jfile.showOpenDialog(jfile);  
//          filePath = jfile.getDialogTitle()+jfile.getSelectedFile().getName();  
//          System.out.println(jfile.getSelectedFile());  
            FileDialog dialog = new FileDialog(new JFrame(),"��....",FileDialog.LOAD);  
            dialog.setVisible(true);  
            filePath = dialog.getDirectory() + dialog.getFile();  
            System.out.println(filePath);  
            File file = new File(filePath);  
            BufferedReader br = null;  
            StringBuilder sb = new StringBuilder();  
            try{  
                br = new BufferedReader (new FileReader(file));  
                String str = null;  
                while ((str = br.readLine()) != null){  
                        sb.append(str).append("\n");  
                    }  
                content.setText(sb.toString());  
            }  
            catch(FileNotFoundException e1){  
                e1.printStackTrace();  
            }  
            catch(IOException e1){  
                e1.printStackTrace();  
            }  
            finally{  
                if(br != null){  
                    try{  
                        br.close();  
                    }  
                    catch(IOException e1){  
                        e1.printStackTrace();  
                    }  
                }  
            }  
        }            
       });  
       //����˵���Ĺ���ʵ��  
       saveitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
//              FileDialog dialog = new FileDialog(new JFrame(),"����....",FileDialog.SAVE);  
//              dialog.setVisible(true);  
//              filePath = dialog.getDirectory() + dialog.getFile();  
//              File file = new File(filePath);  
//              BufferedWriter bw = null;  
//                          try{  
//                              bw = new BufferedWriter(new FileWriter(file));  
//                              bw.write(content.getText());  
//                          }  
//                          catch(FileNotFoundException e1){  
//                              e1.printStackTrace();  
//                          }  
//                          catch(IOException e1){  
//                              e1.printStackTrace();  
//                          }  
//                          finally{  
//                              if(bw != null){  
//                                  try{  
//                                      bw.close();  
//                                  }  
//                                  catch(IOException e1){  
//                                      e1.printStackTrace();  
//                                  }  
//                              }  
//                          }  
                FileDialog dialog = new FileDialog(new JFrame(),"����....",FileDialog.SAVE);  
                dialog.setVisible(true);  
                filePath = dialog.getDirectory() + dialog.getFile();  
                if(filePath.equals("")){//û��·��ʱ�������Ϊ  
                       JFileChooser jfc = new JFileChooser();//����ѡ�񱣴�·�����ļ���  
                           int bcf = jfc.showSaveDialog(jf);//�������洰��  
  
                           if(bcf == JFileChooser.APPROVE_OPTION){  
                                    try {  
                                        //�����ļ�  
                                        BufferedWriter bfw = new BufferedWriter(  
                                                new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                                        filePath = jfc.getSelectedFile().getAbsolutePath();  
                                        bfw.write(content.getText());//���ļ�д������  
                                        bfw.flush();  
                                        bfw.close();//�ر������  
                                    } catch (IOException ex) {  
                                        Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                                    }  
                           }  
                   }  
                   else{//·����Ϊ��ʱ��������ԭ����·����  
                       try {  
                           //�����ļ�  
                           BufferedWriter bfw = new BufferedWriter(  
                                   new FileWriter(  
                                   new File(filePath)));  
                           bfw.write(content.getText());//���ļ�д������  
                           bfw.flush();  
                           bfw.close();//�ر������  
                       } catch (IOException ex) {  
                           Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                       }  
                   }  
            }  
                
           });  
       //���Ϊ�˵���Ĺ���ʵ��  
       saveasitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                 JFileChooser jfc = new JFileChooser();//����ѡ�񱣴�·�����ļ���  
                 int bcf = jfc.showSaveDialog(jf);//�������洰��  
  
                 if(bcf == JFileChooser.APPROVE_OPTION){  
                          try {  
                              //�����ļ�  
                              BufferedWriter bfw = new BufferedWriter(  
                                      new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                              filePath = jfc.getSelectedFile().getAbsolutePath();  
                              bfw.write(content.getText());//���ļ�д������  
                              bfw.flush();  
                              bfw.close();//�ر������  
                          } catch (IOException ex) {  
                              Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                          }  
                 }  
            }  
                 
           });  
       //ҳ�����ò˵���Ĺ���ʵ��  
       setitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
       //��ӡ�˵���Ĺ���ʵ��  
       printitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
       //�˳��˵���Ĺ���ʵ��  
       exititem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                Object[] options = { "�ǵģ���Ҫ�˳�", "������˼�������" };  
                int option = JOptionPane.showOptionDialog(null, "��ȷ��Ҫ�˳���",  
                         "�˳���ʾ....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,  
                          null,options, options[0]);       
                 if(option == JOptionPane.OK_OPTION){  
                 System.exit(0);  
                 }  
            }  
              
                 
           });  
     //�����༭�˵��ϵĸ����˵����ӵ��˵���  
       MenuItem undoitem = new MenuItem("������U��");  
       undoitem.setShortcut(new MenuShortcut(KeyEvent.VK_Z,false));  
       editmenu.add(undoitem);    
       MenuItem cutitem = new MenuItem("���У�T��");  
       cutitem.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));  
       editmenu.add(cutitem);    
       MenuItem copyitem = new MenuItem("���ƣ�C��");  
       copyitem.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));  
       editmenu.add(copyitem);    
       MenuItem pasteitem = new MenuItem("ճ����P��");  
       pasteitem.setShortcut(new MenuShortcut(KeyEvent.VK_V,false));  
       editmenu.add(pasteitem);    
       MenuItem deleteitem = new MenuItem("ɾ����L��");  
       deleteitem.setShortcut(new MenuShortcut(KeyEvent.VK_DELETE,false));  
       editmenu.add(deleteitem);    
       editmenu.addSeparator();  
       MenuItem finditem = new MenuItem("���ң�F��");  
       finditem.setShortcut(new MenuShortcut(KeyEvent.VK_F,false));  
       editmenu.add(finditem);    
       MenuItem nextitem = new MenuItem("������һ����N��");  
       nextitem.setShortcut(new MenuShortcut(KeyEvent.VK_3,false));  
       editmenu.add(nextitem);    
       MenuItem replaceitem = new MenuItem("�滻��R��");  
       replaceitem.setShortcut(new MenuShortcut(KeyEvent.VK_H,false));  
       editmenu.add(replaceitem);    
       MenuItem turntoitem = new MenuItem("ת����G��");  
       turntoitem.setShortcut(new MenuShortcut(KeyEvent.VK_G,false));  
       editmenu.add(turntoitem);    
       editmenu.addSeparator();  
       //��ѡ�˵���  
       Menu choicemenu = new Menu("ѡ��(C)");  
       MenuItem allitem = new MenuItem("ȫѡ��A��");  
       allitem.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));  
       choicemenu.add(allitem);  
       MenuItem fanxiangitem = new MenuItem("����ѡ��(B)");  
       fanxiangitem.setShortcut(new MenuShortcut(KeyEvent.VK_B,false));  
       choicemenu.add(fanxiangitem);  
       MenuItem chieseitem = new MenuItem("ѡ���֣�C��");  
       chieseitem.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));  
       choicemenu.add(chieseitem);  
       editmenu.add(choicemenu);    
       //�༭�˵����ʱ��/������  
       MenuItem dateitem = new MenuItem("ʱ��/���ڣ�D��");  
       dateitem.setShortcut(new MenuShortcut(KeyEvent.VK_5,false));  
       editmenu.add(dateitem);   
         
      //��Ӽ�������ʵ�ֱ༭�˵��ϵĸ����˵���Ĺ���  
      //�����˵���Ĺ���ʵ��  
       undoitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //���в˵���Ĺ���ʵ��  
       cutitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            String text = content.getSelectedText();  
            StringSelection selection = new StringSelection(text);  
            clipboard.setContents(selection, null);  
            if(text.length() == 0){  
                return;  
            }  
            else{  
            content.replaceRange("", content.getSelectionStart(),content.getSelectionEnd());  
            }  
        }  
             
       });  
     //���Ʋ˵���Ĺ���ʵ��  
       copyitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            String text = content.getSelectedText();  
            StringSelection selection = new StringSelection(text);  
            clipboard.setContents(selection, null);  
        }  
             
       });  
     //ճ���˵���Ĺ���ʵ��  
       pasteitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            Transferable contents = clipboard.getContents(this);  
            String str =null;  
            try {  
                str = (String) contents.getTransferData(DataFlavor.stringFlavor);  
            } catch (UnsupportedFlavorException e1) {  
                e1.printStackTrace();  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
            if (str == null)  
                return;  
            try {  
                content.replaceRange(str,content.getSelectionStart(),content.getSelectionEnd());  
            }   
            catch (Exception e1) {  
                e1.printStackTrace();  
            }  
        }  
             
       });  
     //ɾ���˵���Ĺ���ʵ��  
       deleteitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            content.replaceRange("",content.getSelectionStart(),content.getSelectionEnd());  
        }  
             
       });  
     //���Ҳ˵���Ĺ���ʵ��  
       finditem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            final JDialog dialog = new JDialog(jf,"�����ַ���...",true);  
            dialog.setBounds(560,250,310,130);  
            JLabel find = new JLabel("�������ַ��� :");  
            final JTextField findtext = new JTextField(1);  
            JButton jbu = new JButton("����");  
            dialog.setLayout(null);  
            find.setBounds(10,30,90,20);  
            findtext.setBounds(100,30,90,20);  
            jbu.setBounds(200,30,80,20);  
            dialog.add(find);  
            dialog.add(findtext);  
            dialog.add(jbu);  
            jbu.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                    String text = content.getText();  
                    String str = findtext.getText();  
                    int end = text.length();  
                    int len = str.length();  
                    int start = content.getSelectionEnd();  
                    if(start == end){  
                        start = 0;  
                    }  
                    for(;start<=end-len;start++){  
                        if(text.substring(start,start+len).equals(str)){  
                            content.setSelectionStart(start);  
                            content.setSelectionEnd(start+len);  
                            return;  
                        }  
                    }  
                    //���Ҳ��������ַ������򽫹������ĩβ   
                    content.setSelectionStart(end);  
                    content.setSelectionEnd(end);  
                }  
                     
               });  
            dialog.addWindowListener(new WindowAdapter(){  
                public void windowClosing(WindowEvent e){  
                    dialog.dispose();  
                }  
            });  
            dialog.setResizable(false);  
            dialog.setVisible(true);  
        }  
             
       });  
     //������һ���˵���Ĺ���ʵ��  
       nextitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //�滻�˵���Ĺ���ʵ��  
       replaceitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              final JDialog dialog = new JDialog(jf,"�ַ����滻...",true);  
              dialog.setBounds(560,250,310,180);  
              final JLabel tihuan = new JLabel("������Ҫ�滻���ַ��� ��");  
              JLabel mubiao = new JLabel("�������滻����ַ��� ��");  
              JTextField jtf1 = new JTextField(10);  
              JTextField jtf2 = new JTextField(10);  
              JButton jb = new JButton("�滻");  
              dialog.setLayout(null);  
              tihuan.setBounds(10,30,150,20);  
              mubiao.setBounds(10,70,150,20);  
              jtf1.setBounds(160,30,110,20);  
              jtf2.setBounds(160,70,110,20);  
              jb.setBounds(100,110,80,20);  
              dialog.add(tihuan);  
              dialog.add(mubiao);  
              dialog.add(jtf1);  
              dialog.add(jtf2);  
              dialog.add(jb);  
              final String text = content.getText();  
              final String str1 = tihuan.getText();  
              final String str2 = mubiao.getText();  
              jb.addActionListener(new ActionListener(){  
              public void actionPerformed(ActionEvent e) {  
                if(content.getSelectedText().equals(tihuan.getText())){  
                       content.replaceRange(str2,content.getSelectionStart(),content.getSelectionEnd());  
                     }  
                else {  
                     int end=text.length();  
                     int len=str1.length();  
                     int start=content.getSelectionEnd();  
                     if(start==end) start=0;  
                     for(;start<=end-len;start++){  
                         if(text.substring(start,start+len).equals(str1)){  
                             content.setSelectionStart(start);  
                             content.setSelectionEnd(start+len);  
                             return;  
                         }  
                      }  
                      //���Ҳ��������ַ������򽫹������ĩβ  
                      content.setSelectionStart(end);  
                      content.setSelectionEnd(end);  
                     }  
                      
                   }  
                 
                });  
              dialog.setResizable(false);  
              dialog.setVisible(true);  
        }  
             
       });  
     //ת���˵���Ĺ���ʵ��  
       turntoitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //ȫѡ�˵���Ĺ���ʵ��  
       allitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            content.selectAll();  
        }  
             
       });  
     //����ѡ��˵���Ĺ���ʵ��  
       fanxiangitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //ѡ���ֲ˵���Ĺ���ʵ��  
       chieseitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
       //ʱ��˵���Ĺ���ʵ��  
       dateitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //������ʽ�˵��ϵĸ����˵����ӵ��˵���    
       CheckboxMenuItem lineturnitem = new CheckboxMenuItem("�Զ����У�W��");  
       formatmenu.add(lineturnitem);  
       formatmenu.addSeparator();  
       MenuItem worditem = new MenuItem("���壨F��");  
       formatmenu.add(worditem);  
       worditem.setEnabled(true);  
       formatmenu.addSeparator();  
       MenuItem coloritem = new MenuItem("������ɫ��C��");  
       formatmenu.add(coloritem);  
         
     //��Ӽ�������ʵ�ָ�ʽ�˵��ϵĸ����˵���Ĺ���  
    //�Զ����в˵���Ĺ���ʵ��  
       lineturnitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
    //����˵���Ĺ���ʵ��  
       worditem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                 final JFrame ztsz = new JFrame("��������...");//�������ô���  
                   //����  
                   ztsz.setLocation(150, 200);  
                   jf.setEnabled(false);//�ı��༭���岻���ã�  
                   final JComboBox jc = new JComboBox(  
                           GraphicsEnvironment.getLocalGraphicsEnvironment()  
                           .getAvailableFontFamilyNames());  
                   jc.setLocation(30, 80);  
                   Container c = ztsz.getContentPane();  
                   JPanel jp = new JPanel();  
                   jp.add(jc,new FlowLayout());  
  
                   //����  
                   String[]   faceString={"����","����","б��","��б��"};  
                   String[]   sizeString={"����","С��","һ��","Сһ","����","С��",  
                          "����","С��","�ĺ�","С��","���","С��","����","С��","�ߺ�",  
                          "�˺�","5","8","9","10","11","12","14","16","18","20","22","24",  
                          "26","28","36","48","72"};  
                   final JComboBox zx = new JComboBox(faceString);  
                   final JComboBox dx = new JComboBox(sizeString);  
                   final JButton sure = new JButton("ȷ��");  
                   final JButton cancel = new JButton("ȡ��");  
                     
                   jp.add(zx);  
                   jp.add(dx);  
                   jp.add(sure);  
                   jp.add(cancel);  
                   c.add(jp);  
  
  
                   //ȷ��  
                   sure.addActionListener(new ActionListener(){  
                       public void actionPerformed(ActionEvent e){//���ı����ó���ѡ������  
                               if(!content.getText().equals("")){  
                                   content.setFont(new Font(  
                                       jc.getActionCommand(),zx.getSelectedIndex(),  
                                       dx.getSelectedIndex()));  
                                       jf.setEnabled(true);//�ı��༭�������  
                                       ztsz.dispose();  
                               }  
                               else{  
                                   JOptionPane.showMessageDialog(null,  
                                           "�����ı��л�û�����ݣ����������ݺ��������ã�"   
                                           ,"��Ϣ...",JOptionPane.INFORMATION_MESSAGE);  
                                   jf.setEnabled(true);  
                                   ztsz.dispose();  
                               }  
                        }  
                   });  
                   cancel.addActionListener(new ActionListener(){//ȡ��  
                       public void actionPerformed(ActionEvent e){  
                               jf.setEnabled(true);//�ı��༭�������  
                               ztsz.dispose();//�ر��������ô���  
                       }  
                   });  
                   ztsz.setSize(360, 100);//���ô��峤��100�Ϳ��360  
                   ztsz.setVisible(true);//����ɼ�  
                   ztsz.setResizable(false);//��ֹ�Ŵ���  
            }  
          });  
     //������ɫ�˵���Ĺ���ʵ��  
       coloritem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                color=JColorChooser.showDialog(jf,"",color);  
                content.setForeground(color);  
            }  
                 
           });  
         
    //��Ӽ�������ʵ�ֲ鿴�˵��ϵĸ����˵���Ĺ���  
    //����ͳ�Ʋ˵���Ĺ���ʵ��    
        MenuItem countitem = new MenuItem("����ͳ�ƣ�C��");    
        viewmenu.add(countitem);  
        countitem.setEnabled(true);  
        countitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
                      
                }  
                  
        });  
    //״̬���˵���Ĺ���ʵ��    
        MenuItem stateitem = new MenuItem("״̬����S��");    
        viewmenu.add(stateitem);  
        stateitem.setEnabled(false);  
        stateitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
              
        });  
          
    //���������˵��ϵĸ����˵����ӵ��˵���  
        MenuItem findhelpitem = new MenuItem("�鿴������H��");    
        helpmenu.add(findhelpitem);  
        findhelpitem.setEnabled(false);  
        helpmenu.addSeparator();  
        MenuItem aboutboxitem = new MenuItem("���ڼ��±���A��");    
        helpmenu.add(aboutboxitem);  
        helpmenu.addSeparator();  
        MenuItem writeritem = new MenuItem("�������ߣ�S��");    
        helpmenu.add(writeritem);  
    //��Ӽ�������ʵ�ְ����˵��ϵĸ����˵���Ĺ���  
    //�鿴�����˵���Ĺ���ʵ��   
        findhelpitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                  
            }  
        });  
    //���ڼ��±��˵���Ĺ���ʵ��    
        aboutboxitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JOptionPane.showMessageDialog(jf,"������ɹ¶���Ұ��������\n����ҪԴ���룬��ʱ��ӭ��ϵ���ߣ�\n" +  
                        "�������䣺sunchuanhui212@126.com\nQQ�ţ�2442701497\n�����������ʵ����Microsoft���±��Ĺ���\n" +  
                        "�������ˡ�����ѡ�񡱣���ѡ���֡�\n" +  
                        "������ͳ�ơ�,���Զ����桱�ȹ���  ...\nϣ����ϲ����\n" +  
                        "�����κ����ʼ������������ʱ��ӭָ����\n���ǽ�������Ŭ��������������\n" +  
                        "���лл����ʹ�ã�\n��Ȩ���У�������Ȩ��","���ڼ��±�...",JOptionPane.INFORMATION_MESSAGE);  
            }  
        });  
    //�������߲˵���Ĺ���ʵ��    
        writeritem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JOptionPane.showMessageDialog(jf,"���ߣ��¶���Ұ��\n�Ա���\n���᣺��������\n�����գ�1990��11��9��\n" +  
                        "����ԺУ���Ϻ�Ӧ�ü���ѧԺ\n�־ӵأ��Ϻ�\n���ҽ��ܣ���˧Ҳ����\nż�񣺰���˹̹\n" +  
                        "��ϲ���ĸ��֣�����\n�������ĵط�������\n�����������Դ������\n" +  
                        "                 �ڷ����ͻԻ�\n��ϲ���Ļ�����Ը���һ��ʯ�ţ��������紵����������\n" +  
                        "                          �������ɹ��ֻ����������߹�...\n" +  
                        "���룺����ж�����ж�����\n","��������...",JOptionPane.INFORMATION_MESSAGE);  
            }  
        });  
    //�رճ����¼�  
     jf.addWindowListener(new WindowAdapter(){  
         //����ر�ʱ�ķ���  
         public void windowClosing(WindowEvent e){  
             int option = JOptionPane.showConfirmDialog(null, "��ȷ���ر���",  
                     "�ر���ʾ....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);  
             if(option == JOptionPane.OK_OPTION){  
             ((Window) e.getComponent()).dispose();  
             System.exit(0);  
             }  
       }      
     });        
   }  
   public static void main(String[] args){  
       new L8_7();  
   }  
}  
//�¹��룺  
//���±�����������ֺй��ܣ������ں�̨����  
//���򲢲�ʵ�ʱ��������ļ���ֻ���������ļ��ĵ�ַ  
//Ϊ������20M�ռ��20M�����ݿ��������ֲ���  
//Ϊ����������Զ����湦�ܣ�ÿһ���ӱ���һ�Σ���̨����  
//����Ҫ�õ����߳�  
//����û�ѡ��ı����ַ��Ĭ�ϵĵ�ַ��ͬ����ɾ��Ĭ�ϵ�ַ������ļ�  
//�����ڱ��β�����һֱʹ���û�ѡ��ı����ַ  
//�����´β���ʱ��ʹ�ñ�����Ĭ�ϵĵ�ַ  
//�����û�Ĭ�ϵĵ�ַ�����û����ҵ�����Ϊ�û�������ļ�  
//����ڡ����ڼ��±������ĵ��в�����Ӧ�ĳ����ӣ������û�  
//�����������û��ڳ���������ͻȻ�ϵ�ʱ�Ͷ��ɹ������ڸ���� 