//记事本源代码，来源于网络，学习使用

package jingjie;
import java.awt.*;   
import java.awt.datatransfer.*;    
import java.awt.event.*;  
import java.io.*;    
import java.util.logging.*;   
import javax.swing.*;  
    
public class L8_7 {  
   // 记事本的具体实现类  
   private static final long serialVersionUID = 1L;  
   private  TextArea content;   
   private  String filePath = "";//先让路径为空  
   Color color=Color.red;  
   Toolkit toolKit = Toolkit.getDefaultToolkit();  
   Clipboard clipboard = toolKit.getSystemClipboard();  
   public L8_7(){  
       //创建一个JFrame对象；并设置相关属性  
       final JFrame jf = new JFrame("我的记事本");  
       jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
       jf.setBounds(100,100,500,500);  
       jf.setResizable(true);  
       jf.setVisible(true);  
       //创建菜单栏  
       MenuBar menu = new MenuBar();  
       jf.setMenuBar(menu);  
       //创建并添加文本框  
       content = new TextArea("",50,50,TextArea.SCROLLBARS_VERTICAL_ONLY);  
       jf.add(content);  
       content.setVisible(true);      
       content.requestFocusInWindow();  
       //菜单栏添加内容  
       Menu filemenu = new Menu("文件（F）");  
       Menu editmenu = new Menu("编辑（E）");  
       Menu formatmenu = new Menu("格式（O）");  
       Menu viewmenu = new Menu("查看（V）");  
       Menu helpmenu = new Menu("帮助（H）");  
       menu.add(filemenu);  
       menu.add(editmenu);  
       menu.add(formatmenu);  
       menu.add(viewmenu);  
       menu.add(helpmenu);  
       //创建文件菜单上的各个菜单项并添加到菜单上  
       MenuItem newitem = new MenuItem("新建（N）");  
       newitem.setShortcut(new MenuShortcut(KeyEvent.VK_N,false));  
       filemenu.add(newitem);  
       MenuItem openitem = new MenuItem("打开（O）");  
       openitem.setShortcut(new MenuShortcut(KeyEvent.VK_O,false));  
       filemenu.add(openitem);  
       MenuItem saveitem = new MenuItem("保存（S）");  
       saveitem.setShortcut(new MenuShortcut(KeyEvent.VK_S,false));  
       filemenu.add(saveitem);  
       MenuItem saveasitem = new MenuItem("另存为（A）");  
       saveasitem.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));  
       filemenu.add(saveasitem);  
       MenuItem setitem = new MenuItem("页面设置（U）");  
       setitem.setShortcut(new MenuShortcut(KeyEvent.VK_U,false));  
       filemenu.add(setitem);  
       setitem.setEnabled(false);  
       MenuItem printitem = new MenuItem("打印（P）");  
       printitem.setShortcut(new MenuShortcut(KeyEvent.VK_P,false));  
       filemenu.add(printitem);  
       printitem.setEnabled(false);  
       filemenu.addSeparator();  
       MenuItem exititem = new MenuItem("退出（X）");  
       exititem.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));  
       filemenu.add(exititem);  
       //添加监听器来实现文件菜单上的各个菜单项的功能  
       //新建菜单项的功能实现  
       newitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
               String con = content.getText();  
               if(!con.equals("")){//文本域里文本不为空  
                   int result = JOptionPane.showConfirmDialog(  
                           null, ("是否要保存？"),("保存文件..."),JOptionPane.YES_NO_CANCEL_OPTION);  
                   if(result == JOptionPane.NO_OPTION){//不保存  
                       content.setText("");  
                   }  
                     
                   else if(result == JOptionPane.CANCEL_OPTION){//取消新建  
                   }  
                     
                   else if(result == JOptionPane.YES_OPTION)//选择保存  
                   {  
                       JFileChooser jfc = new JFileChooser();//用于选择保存路径的文件名  
                       int bcf = jfc.showSaveDialog(jf);  
  
                       if(bcf == JFileChooser.APPROVE_OPTION){  
                                try {  
                                    //保存文件  
                                    BufferedWriter bfw = new BufferedWriter(  
                                            new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                                    filePath = jfc.getSelectedFile().getAbsolutePath()+".txt";//获取文件保存的路径  
                                    bfw.write(con);//向文件写出数据  
                                    bfw.flush();  
                                    bfw.close();//关闭输出流  
                                } catch (IOException ex) {  
                                    Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                                }  
                           new L8_7();//新建文本文件  
                       }  
                   }  
               }  
           }  
             
       });  
       //打开菜单项的功能实现  
        openitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
//          JFileChooser jfile = new JFileChooser();  
//          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt","txt");  
//          jfile.setFileFilter(filter);  
//          jfile.setVisible(true);  
//          int returnval = jfile.showOpenDialog(jfile);  
//          filePath = jfile.getDialogTitle()+jfile.getSelectedFile().getName();  
//          System.out.println(jfile.getSelectedFile());  
            FileDialog dialog = new FileDialog(new JFrame(),"打开....",FileDialog.LOAD);  
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
       //保存菜单项的功能实现  
       saveitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
//              FileDialog dialog = new FileDialog(new JFrame(),"保存....",FileDialog.SAVE);  
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
                FileDialog dialog = new FileDialog(new JFrame(),"保存....",FileDialog.SAVE);  
                dialog.setVisible(true);  
                filePath = dialog.getDirectory() + dialog.getFile();  
                if(filePath.equals("")){//没有路径时，就另存为  
                       JFileChooser jfc = new JFileChooser();//用于选择保存路径的文件名  
                           int bcf = jfc.showSaveDialog(jf);//弹出保存窗口  
  
                           if(bcf == JFileChooser.APPROVE_OPTION){  
                                    try {  
                                        //保存文件  
                                        BufferedWriter bfw = new BufferedWriter(  
                                                new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                                        filePath = jfc.getSelectedFile().getAbsolutePath();  
                                        bfw.write(content.getText());//向文件写出数据  
                                        bfw.flush();  
                                        bfw.close();//关闭输出流  
                                    } catch (IOException ex) {  
                                        Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                                    }  
                           }  
                   }  
                   else{//路径不为空时，保存在原来的路径下  
                       try {  
                           //保存文件  
                           BufferedWriter bfw = new BufferedWriter(  
                                   new FileWriter(  
                                   new File(filePath)));  
                           bfw.write(content.getText());//向文件写出数据  
                           bfw.flush();  
                           bfw.close();//关闭输出流  
                       } catch (IOException ex) {  
                           Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                       }  
                   }  
            }  
                
           });  
       //另存为菜单项的功能实现  
       saveasitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                 JFileChooser jfc = new JFileChooser();//用于选择保存路径的文件名  
                 int bcf = jfc.showSaveDialog(jf);//弹出保存窗口  
  
                 if(bcf == JFileChooser.APPROVE_OPTION){  
                          try {  
                              //保存文件  
                              BufferedWriter bfw = new BufferedWriter(  
                                      new FileWriter(new File(jfc.getSelectedFile().getAbsolutePath()+".txt")));  
                              filePath = jfc.getSelectedFile().getAbsolutePath();  
                              bfw.write(content.getText());//向文件写出数据  
                              bfw.flush();  
                              bfw.close();//关闭输出流  
                          } catch (IOException ex) {  
                              Logger.getLogger(L8_7.class.getName()).log(Level.SEVERE, null, ex);  
                          }  
                 }  
            }  
                 
           });  
       //页面设置菜单项的功能实现  
       setitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
       //打印菜单项的功能实现  
       printitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
       //退出菜单项的功能实现  
       exititem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                Object[] options = { "是的，我要退出", "不好意思，点错了" };  
                int option = JOptionPane.showOptionDialog(null, "您确定要退出吗？",  
                         "退出提示....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,  
                          null,options, options[0]);       
                 if(option == JOptionPane.OK_OPTION){  
                 System.exit(0);  
                 }  
            }  
              
                 
           });  
     //创建编辑菜单上的各个菜单项并添加到菜单上  
       MenuItem undoitem = new MenuItem("撤销（U）");  
       undoitem.setShortcut(new MenuShortcut(KeyEvent.VK_Z,false));  
       editmenu.add(undoitem);    
       MenuItem cutitem = new MenuItem("剪切（T）");  
       cutitem.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));  
       editmenu.add(cutitem);    
       MenuItem copyitem = new MenuItem("复制（C）");  
       copyitem.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));  
       editmenu.add(copyitem);    
       MenuItem pasteitem = new MenuItem("粘贴（P）");  
       pasteitem.setShortcut(new MenuShortcut(KeyEvent.VK_V,false));  
       editmenu.add(pasteitem);    
       MenuItem deleteitem = new MenuItem("删除（L）");  
       deleteitem.setShortcut(new MenuShortcut(KeyEvent.VK_DELETE,false));  
       editmenu.add(deleteitem);    
       editmenu.addSeparator();  
       MenuItem finditem = new MenuItem("查找（F）");  
       finditem.setShortcut(new MenuShortcut(KeyEvent.VK_F,false));  
       editmenu.add(finditem);    
       MenuItem nextitem = new MenuItem("查找下一个（N）");  
       nextitem.setShortcut(new MenuShortcut(KeyEvent.VK_3,false));  
       editmenu.add(nextitem);    
       MenuItem replaceitem = new MenuItem("替换（R）");  
       replaceitem.setShortcut(new MenuShortcut(KeyEvent.VK_H,false));  
       editmenu.add(replaceitem);    
       MenuItem turntoitem = new MenuItem("转到（G）");  
       turntoitem.setShortcut(new MenuShortcut(KeyEvent.VK_G,false));  
       editmenu.add(turntoitem);    
       editmenu.addSeparator();  
       //复选菜单项  
       Menu choicemenu = new Menu("选择(C)");  
       MenuItem allitem = new MenuItem("全选（A）");  
       allitem.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));  
       choicemenu.add(allitem);  
       MenuItem fanxiangitem = new MenuItem("反向选择(B)");  
       fanxiangitem.setShortcut(new MenuShortcut(KeyEvent.VK_B,false));  
       choicemenu.add(fanxiangitem);  
       MenuItem chieseitem = new MenuItem("选择汉字（C）");  
       chieseitem.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));  
       choicemenu.add(chieseitem);  
       editmenu.add(choicemenu);    
       //编辑菜单项的时间/日期项  
       MenuItem dateitem = new MenuItem("时间/日期（D）");  
       dateitem.setShortcut(new MenuShortcut(KeyEvent.VK_5,false));  
       editmenu.add(dateitem);   
         
      //添加监听器来实现编辑菜单上的各个菜单项的功能  
      //撤销菜单项的功能实现  
       undoitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //剪切菜单项的功能实现  
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
     //复制菜单项的功能实现  
       copyitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            String text = content.getSelectedText();  
            StringSelection selection = new StringSelection(text);  
            clipboard.setContents(selection, null);  
        }  
             
       });  
     //粘贴菜单项的功能实现  
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
     //删除菜单项的功能实现  
       deleteitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            content.replaceRange("",content.getSelectionStart(),content.getSelectionEnd());  
        }  
             
       });  
     //查找菜单项的功能实现  
       finditem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            final JDialog dialog = new JDialog(jf,"查找字符串...",true);  
            dialog.setBounds(560,250,310,130);  
            JLabel find = new JLabel("请输入字符串 :");  
            final JTextField findtext = new JTextField(1);  
            JButton jbu = new JButton("查找");  
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
                    //若找不到待查字符串，则将光标置于末尾   
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
     //查找下一个菜单项的功能实现  
       nextitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //替换菜单项的功能实现  
       replaceitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              final JDialog dialog = new JDialog(jf,"字符串替换...",true);  
              dialog.setBounds(560,250,310,180);  
              final JLabel tihuan = new JLabel("请输入要替换的字符串 ：");  
              JLabel mubiao = new JLabel("请输入替换后的字符串 ：");  
              JTextField jtf1 = new JTextField(10);  
              JTextField jtf2 = new JTextField(10);  
              JButton jb = new JButton("替换");  
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
                      //若找不到待查字符串，则将光标置于末尾  
                      content.setSelectionStart(end);  
                      content.setSelectionEnd(end);  
                     }  
                      
                   }  
                 
                });  
              dialog.setResizable(false);  
              dialog.setVisible(true);  
        }  
             
       });  
     //转到菜单项的功能实现  
       turntoitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //全选菜单项的功能实现  
       allitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
            content.selectAll();  
        }  
             
       });  
     //反向选择菜单项的功能实现  
       fanxiangitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //选择汉字菜单项的功能实现  
       chieseitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
       //时间菜单项的功能实现  
       dateitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
              
        }  
             
       });  
     //创建格式菜单上的各个菜单项并添加到菜单上    
       CheckboxMenuItem lineturnitem = new CheckboxMenuItem("自动换行（W）");  
       formatmenu.add(lineturnitem);  
       formatmenu.addSeparator();  
       MenuItem worditem = new MenuItem("字体（F）");  
       formatmenu.add(worditem);  
       worditem.setEnabled(true);  
       formatmenu.addSeparator();  
       MenuItem coloritem = new MenuItem("字体颜色（C）");  
       formatmenu.add(coloritem);  
         
     //添加监听器来实现格式菜单上的各个菜单项的功能  
    //自动换行菜单项的功能实现  
       lineturnitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
                 
           });  
    //字体菜单项的功能实现  
       worditem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                 final JFrame ztsz = new JFrame("字体设置...");//字体设置窗口  
                   //字体  
                   ztsz.setLocation(150, 200);  
                   jf.setEnabled(false);//文本编辑窗体不可用！  
                   final JComboBox jc = new JComboBox(  
                           GraphicsEnvironment.getLocalGraphicsEnvironment()  
                           .getAvailableFontFamilyNames());  
                   jc.setLocation(30, 80);  
                   Container c = ztsz.getContentPane();  
                   JPanel jp = new JPanel();  
                   jp.add(jc,new FlowLayout());  
  
                   //字形  
                   String[]   faceString={"正常","粗体","斜体","粗斜体"};  
                   String[]   sizeString={"初号","小初","一号","小一","二号","小二",  
                          "三号","小三","四号","小四","五号","小五","六号","小六","七号",  
                          "八号","5","8","9","10","11","12","14","16","18","20","22","24",  
                          "26","28","36","48","72"};  
                   final JComboBox zx = new JComboBox(faceString);  
                   final JComboBox dx = new JComboBox(sizeString);  
                   final JButton sure = new JButton("确定");  
                   final JButton cancel = new JButton("取消");  
                     
                   jp.add(zx);  
                   jp.add(dx);  
                   jp.add(sure);  
                   jp.add(cancel);  
                   c.add(jp);  
  
  
                   //确定  
                   sure.addActionListener(new ActionListener(){  
                       public void actionPerformed(ActionEvent e){//将文本设置成所选的字体  
                               if(!content.getText().equals("")){  
                                   content.setFont(new Font(  
                                       jc.getActionCommand(),zx.getSelectedIndex(),  
                                       dx.getSelectedIndex()));  
                                       jf.setEnabled(true);//文本编辑窗体可用  
                                       ztsz.dispose();  
                               }  
                               else{  
                                   JOptionPane.showMessageDialog(null,  
                                           "您的文本中还没有内容，请输入内容后重新设置！"   
                                           ,"消息...",JOptionPane.INFORMATION_MESSAGE);  
                                   jf.setEnabled(true);  
                                   ztsz.dispose();  
                               }  
                        }  
                   });  
                   cancel.addActionListener(new ActionListener(){//取消  
                       public void actionPerformed(ActionEvent e){  
                               jf.setEnabled(true);//文本编辑窗体可用  
                               ztsz.dispose();//关闭字体设置窗体  
                       }  
                   });  
                   ztsz.setSize(360, 100);//设置窗体长度100和宽度360  
                   ztsz.setVisible(true);//窗体可见  
                   ztsz.setResizable(false);//禁止放大窗体  
            }  
          });  
     //字体颜色菜单项的功能实现  
       coloritem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                color=JColorChooser.showDialog(jf,"",color);  
                content.setForeground(color);  
            }  
                 
           });  
         
    //添加监听器来实现查看菜单上的各个菜单项的功能  
    //字数统计菜单项的功能实现    
        MenuItem countitem = new MenuItem("字数统计（C）");    
        viewmenu.add(countitem);  
        countitem.setEnabled(true);  
        countitem.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e) {  
                      
                }  
                  
        });  
    //状态栏菜单项的功能实现    
        MenuItem stateitem = new MenuItem("状态栏（S）");    
        viewmenu.add(stateitem);  
        stateitem.setEnabled(false);  
        stateitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {  
                  
            }  
              
        });  
          
    //创建帮助菜单上的各个菜单项并添加到菜单上  
        MenuItem findhelpitem = new MenuItem("查看帮助（H）");    
        helpmenu.add(findhelpitem);  
        findhelpitem.setEnabled(false);  
        helpmenu.addSeparator();  
        MenuItem aboutboxitem = new MenuItem("关于记事本（A）");    
        helpmenu.add(aboutboxitem);  
        helpmenu.addSeparator();  
        MenuItem writeritem = new MenuItem("关于作者（S）");    
        helpmenu.add(writeritem);  
    //添加监听器来实现帮助菜单上的各个菜单项的功能  
    //查看帮助菜单项的功能实现   
        findhelpitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                  
            }  
        });  
    //关于记事本菜单项的功能实现    
        aboutboxitem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JOptionPane.showMessageDialog(jf,"本软件由孤独的野狼制作！\n如需要源代码，随时欢迎联系作者！\n" +  
                        "作者邮箱：sunchuanhui212@126.com\nQQ号：2442701497\n本程序基本上实现了Microsoft记事本的功能\n" +  
                        "并新增了“反向选择”，“选择汉字”\n" +  
                        "“字数统计”,“自动保存”等功能  ...\n希望您喜欢！\n" +  
                        "如有任何疑问及改善意见，随时欢迎指出，\n我们将尽最大的努力满足您的需求！\n" +  
                        "最后谢谢您的使用！\n版权所有，请勿侵权！","关于记事本...",JOptionPane.INFORMATION_MESSAGE);  
            }  
        });  
    //关于作者菜单项的功能实现    
        writeritem.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JOptionPane.showMessageDialog(jf,"作者：孤独的野狼\n性别：男\n籍贯：湖南邵阳\n出生日：1990年11月9日\n" +  
                        "本科院校：上海应用技术学院\n现居地：上海\n自我介绍：不帅也不丑\n偶像：爱因斯坦\n" +  
                        "最喜欢的歌手：刀郎\n最向往的地方：北京\n座右铭：疯狂源自梦想\n" +  
                        "                 勤奋铸就辉煌\n最喜欢的话：我愿变成一座石桥，受五百年风吹，五百年雨打，\n" +  
                        "                          五百年日晒，只求你从上面走过...\n" +  
                        "梦想：天地有多大，梦有多潇洒\n","关于作者...",JOptionPane.INFORMATION_MESSAGE);  
            }  
        });  
    //关闭程序事件  
     jf.addWindowListener(new WindowAdapter(){  
         //程序关闭时的方法  
         public void windowClosing(WindowEvent e){  
             int option = JOptionPane.showConfirmDialog(null, "您确定关闭吗？",  
                     "关闭提示....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);  
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
//新构想：  
//记事本程序添加音乐盒功能，音乐在后台播放  
//程序并不实际保存音乐文件，只保存音乐文件的地址  
//为程序保留20M空间或20M的数据库用于音乐播放  
//为本程序添加自动保存功能，每一分钟保存一次，后台保存  
//可能要用到多线程  
//如果用户选择的保存地址与默认的地址不同，则删除默认地址保存的文件  
//并且在本次操作中一直使用用户选择的保存地址  
//但在下次操作时仍使用本程序默认的地址  
//告诉用户默认的地址，让用户能找到程序为用户保存的文件  
//最好在“关于记事本”的文档中插入相应的超链接，方便用户  
//这样做能让用户在出现死机和突然断电时劳动成果不至于付诸东流 