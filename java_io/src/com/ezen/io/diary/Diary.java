package com.ezen.io.diary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Calendar;

public class Diary extends Frame {

    MenuBar menuBar;
    Menu fileMenu;
    MenuItem newMI, openMI, saveMI, exitMI;
    Label timeL, statusL;
    TextArea contentsTA;

    private static int contentLength = 0;

    public Diary() {
        this("제목없음");
    }

    public Diary(String title) {
        super(title);
        menuBar = new MenuBar();
        fileMenu = new Menu("파일");
        newMI = new MenuItem("새로 만들기");
        openMI = new MenuItem("열기");
        saveMI = new MenuItem("저장");
        exitMI = new MenuItem("끝내기");

        timeL = new Label("", Label.RIGHT);
        contentsTA = new TextArea();
        statusL = new Label();
        statusL.setBackground(Color.LIGHT_GRAY);
    }

    public void init() {
        setMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.addSeparator();   // 구분선
        fileMenu.add(exitMI);
        newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
        openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
        saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));
        exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
        add(timeL, BorderLayout.NORTH);
        add(contentsTA, BorderLayout.CENTER);
        add(statusL, BorderLayout.SOUTH);
    }

    private void setTime() {
        timeL.setBackground(new Color(64, 128, 128));
        timeL.setForeground(Color.WHITE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String format = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
                    timeL.setText(format);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private void setNew() {
        contentsTA.setText("");   // 현재는 그냥 지우는 기능
    }

    private void openFile() throws IOException { // 창 열기
        FileDialog fileDialog = new FileDialog(this, "일기장 열기", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String saveFileName = fileDialog.getFile();
//		System.out.println(saveFileName);
        // 과제
        // #1. 파일 다이얼로그에서 선택한 파일의 내용을 읽어서(문자스트림), 텍스트 에리어에 출력
        String path = "/Applications/diary/" + saveFileName;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String lineText = null;
        contentsTA.setText("");   // 파일을 불러온 상태에서 또 다른 파일을 불러왔을 때, 이전에 불러온 파일의 내용을 지우기 위한 코드
        while ((lineText = bufferedReader.readLine()) != null) {
            contentsTA.append(lineText + "\n");
        }
        bufferedReader.close();

    }
//====================================================================================================================//
    private void saveFile() throws IOException {
        FileDialog fileDialog = new FileDialog(this, "일기장 저장", FileDialog.SAVE);
        fileDialog.setVisible(true);
        String saveFileName = fileDialog.getFile();

        if (saveFileName != null) {
//			System.out.println(saveFileName);
//			System.out.println("파일 선택");
            // 일기장.txt
            // 과제
            // #1. 저장파일명 변경 (일기장.txt -> 일기장_2024.2.7.txt)  일기장이라고 저장하면 현재날짜를 뒤에 붙혀서 저장해주기(캘린더 이용)
            // #2. 저장파일의 TA(TextArea)에 입력한 내용을 읽어서 파일에 저장( 문자 스트림 사용 )

            Calendar calendar = Calendar.getInstance();
            String path = "/Applications/diary/" + saveFileName + "_" + calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." +
                    calendar.get(Calendar.DAY_OF_MONTH) + ".txt";

            File file = new File(path);
            if(file.exists()){   // 이름이 같은 파일 있으면 경고 메시지
                JOptionPane.showMessageDialog(null,"이미 존재하는 파일입니다.","경 고", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Writer writer = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String lineText = contentsTA.getText();
            System.out.println(lineText);      // 디버깅용
            bufferedWriter.write(lineText);
            bufferedWriter.flush();
            contentsTA.setText(""); // 저장하면 TextArea 내용 다 지우기
            writer.close();
        }
    }

    private void exit() {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    public void addEventListener() {
        // Window Event  처리
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                setTime();
            }
        });

        // Action Event 처리
        newMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNew();
            }
        });

        openMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openFile();
                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
                    System.out.println("오픈 실패");
                }
            }
        });

        saveMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        exitMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }
}

