PImage[] person = new PImage[7];
int[] dashX = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600};
int[] wrongX = {400, 450, 500};
int[] wrongY = {200, 300, 400};
char[] empty;
char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
ArrayList<Character> chars = new ArrayList<Character>();
ArrayList<Character> wrong = new ArrayList<Character>();
ArrayList<PImage> dashes = new ArrayList<PImage>();
ArrayList<Character> newList;
HashMap<Character, Integer> dup = new HashMap<Character, Integer>();
String word;
char[] wordChars;
PImage hanger;
PImage dash1;
PImage dash2;
PImage dash3;
PImage dash4;
PImage dash5;
PImage dash6;
PImage dash7;
PImage dash8;
PImage dash9;
PImage dash10;
int typed;
int dashY = 700;
int wrongx = 0;
int wrongy = 0;
int wrongCount = 0;
int len;
int pos = -2;
int size = 0;
int thing = 0;
int sub;
boolean wordPicked = false;
boolean added = false;
boolean loss = false;
boolean win = false;
boolean stopIt = false;
int t;
void setup() {
  size(600, 800);
  background(255);
  dash1 = loadImage("HangmanDash.png");
  dash2 = loadImage("HangmanDash.png");
  dash3 = loadImage("HangmanDash.png");
  dash4 = loadImage("HangmanDash.png");
  dash5 = loadImage("HangmanDash.png");
  dash6 = loadImage("HangmanDash.png");
  dash7 = loadImage("HangmanDash.png");
  dash8 = loadImage("HangmanDash.png");
  dash9 = loadImage("HangmanDash.png");
  dash10 = loadImage("HangmanDash.png");
  hanger = loadImage("HangmanHanger.png");
  person[0] = loadImage("HangmanHead.png");
  person[1] = loadImage("HangmanBody.png");
  person[2] = loadImage("HangmanArm.png");
  person[3] = loadImage("HangmanArm2.png");
  person[4] = loadImage("HangmanLeg1.png");
  person[5] = loadImage("HangmanLeg2.png");
  person[6] = loadImage("HangmanFace.png");
  person[0].resize(175, 175);
  person[1].resize(100, 300);
  person[2].resize(150, 100);
  person[3].resize(150, 100);
  person[4].resize(150, 125);
  person[5].resize(160, 90);
  person[6].resize(100, 100);
  hanger.resize(300, 600);
  dash1.resize(50, 50);
  dash2.resize(50, 50);
  dash3.resize(50, 50);
  dash4.resize(50, 50);
  dash5.resize(50, 50);
  dash6.resize(50, 50);
  dash7.resize(50, 50);
  dash8.resize(50, 50);
  dash9.resize(50, 50);
  dash10.resize(50, 50);
}

void draw() {
  background(255);
  /*if(millis()-1000>wait){
  wait = millis()-1000;
  }
  */
  if (!loss&&!win) {
    charLoc();
    word();
    duplicates();
    dude();
    dash();
    Timer();
    wrong();
      if (wrongCount==7) { 
          image(person[6], 100, 175);
      }
  } else if (loss) {
    textSize(96);
    text("You Lose", 80, 200);
    textSize(48);
    text("Word was: " + word, 50, 450);
    text("Press r to Restart", 90, 650);
    for (int i = 0; i<wrong.size(); i++) {
      wrong.remove(i);
    }
    for (int i = 0; i<chars.size(); i++) {
      chars.remove(i);
    }
    restart();
  } else if (win) {
    winner();
    restart();
    for (int i = 0; i<wrong.size(); i++) {
      wrong.remove(i);
    }
    for (int i = 0; i<chars.size(); i++) {
      chars.remove(i);
    }
  }
  if (wrongCount==7) { 
    if(millis() >= t+1000){
    loss = true;
    }
  //}
  }
  if (chars.size()+thing-wrong.size()==word.length()) {
    if(millis() >= t+1000){
    win = true;
    }
    //}
  }
}

void winner() {
  fill(0, 255, 0);
  textSize(96);
  text("You Win", 80, 300);
  textSize(48);
  text("Press r to Restart", 90, 650);
}

void Timer(){
  if(wrongCount!=7&&chars.size()+thing-wrong.size()!=word.length()){
t = millis();
  }
}


void restart() {
  empty = new char[wordChars.length];
  if (key=='r') {
    win = false;
    loss = false;
    wordPicked = false;
    stopIt = false;
    word();
    wrongCount = 0;
    wrongx = 0;
    wrongy = 0;
  }
}

void keyPressed() {
  if(wrongCount<7){
  typed = keyCode;
  for (int i = 0; i<alphabet.length; i++);
  if (!chars.contains(alphabet[typed-65])) {
    chars.add(alphabet[typed-65]);//alphabet keyCode starts at 65
  }
  }
}

void word() {
  if (!wordPicked) {
    String[] words = loadStrings("dictionary.txt");
    word = words[int(random(words.length-1))];
    while (word.length()>10) {
      word = words[int(random(words.length-1))];
    }
    print(word);
    wordPicked = true;
  }
  // System.out.println(word.length());
}

void dash() {
  len = word.length();
  if (wrongCount==5) {
    rotate(-50);
  }
  for (int i = 0; i<len; i++) {
    image(dash1, dashX[i], dashY);
  }
}

public void duplicates() {
  if (!stopIt) {
    thing = 0;
    wordChars = word.toCharArray();
    for(int i = 0; i<alphabet.length; i++){
    dup.remove(alphabet[i]);
    }
    for (char value : wordChars) {
      if ( value>wordChars.length) {
        stopIt = true;
      }
      if (Character.isAlphabetic(value)) {

        if (dup.containsKey(value)) {
          dup.put(value, dup.get(value) + 1);
          if (dup.get(value)>1) {
            thing++;
          }
        } else {
          dup.put(value, 1);
        }
      }
    }
  }
  System.out.println(dup);
}

void charLoc() {
  print(size);
  fill(0, 255, 0);
  textSize(36);
  for (int i = 0; i<len; i++) {
    for (int j = 0; j<chars.size(); j++) {
      if (word!=null) {
        if (word.charAt(i)==chars.get(j)) { 
          text(chars.get(j), dashX[i]+15, dashY+10);
          size = chars.size();
        }
      }
    }
  }
}


void wrong() {
  wrongCount = wrong.size();
  for (int i = 0; i<chars.size(); i++) {
    String seq = chars.get(i).toString();
    if (!word.contains(seq) && !wrong.contains(seq.charAt(0))) {
      wrong.add(chars.get(i));
    }
  }
  for (int i = 0; i < wrongCount; i++) {
    textSize(48);
    fill(255, 0, 0);
    if (i<=2) {
      wrongx = wrongX[i];
      wrongy = wrongY[0];
    }
    if (i>2&&i<=5) {
      wrongx = wrongX[i-3];
      wrongy = wrongY[1];
    }
    if (i==6) {
      wrongx = wrongX[0];
      wrongy = wrongY[2];
    }
    text(wrong.get(i), wrongx, wrongy);
  }
}

void dude() {
  image(hanger, 100, 50);
  if (wrongCount>=1) {
    image(person[0], 60, 125);
  }
  if (wrongCount>=2) {
    image(person[1], 100, 235);
  }
  if (wrongCount>=3) {
    image(person[2], 140, 275);
  }
  if (wrongCount>=4) {
    image(person[3], 5, 275);
  }
  if (wrongCount>=5) {
    rotate(50);
    image(person[4], -13, 508);
  }
  if (wrongCount>=6) {
    rotate(-50);
    image(person[5], 20, 490);
  }
  if (wrongCount>=7) {
    image(person[6], 100, 175);
  }
}

/* Honorable Methods:
 void letterLocation() {//no work
 fill(0, 255, 0);
 textSize(36);
 for (int i = 0; i<wrong.size(); i++) {
 for (int j = 0; i<chars.size(); j++) {
 if (wrong.get(i)!=word.indexOf(chars.get(j))) {
 added = false;
 } else {
 added = true;
 }
 }
 }
 
 for (int i = 0; i < chars.size(); i++) {
 if (word.indexOf(chars.get(i))==-1) { 
 wrong.add(chars.get(i));
 if (millis() -wait>500) {
 if (!added) {
 wrongCount++;
 //System.out.println(wrong.get(i));
 //System.out.println(chars.get(i));
 added = true;
 wait=millis();
 }
 }
 } else {
 text(chars.get(i), dashX[word.indexOf(chars.get(i))] + 15, dashY + 15);
 }
 }
 }
 
 void test2() {
 fill(0, 255, 0);
 textSize(36);
 for (int i = 0; i < chars.size(); i++) {
 for (int index = word.indexOf(chars.get(i)); 
 index >= 0; 
 index = word.indexOf(chars.get(i), index + 1))
 {
 System.out.println(index);
 text(chars.get(i), dashX[index]+15, dashY+10);
 }
 }
 }
 
 void removeDuplicates() {
 newList = new ArrayList<Character>();
 for (Character element : wrong) {
 if (!newList.contains(element)) {
 newList.add(element);
 }
 }
 }
 
 
 */