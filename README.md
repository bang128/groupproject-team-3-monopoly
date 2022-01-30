# groupproject-team-3-monopoly
groupproject-team-3-monopoly created by GitHub Classroom
Creating a new class named SettingPane extended from GraphicsPane
SettingPane:
  Create a private instance of MainApplication (named "program) like other Pane classes
  Create some private instances of GImage for the pane label and the prompt to ask players choose their icons
  Create a private ArrayList of GImage to store 5 icon options (named "ops")
  Create a private int for player num and initialize to 0
  SettingPane constructor, parameter of MainApplication type:
    initialize program with the parameter
    initialize the pane label and prompt (including font, size and color settings)
    call a function to add each option image to ops arraylist
  Add-option-image function:
    Loop of 5 (5 options):
      add each option image to ops arraylist
      adjust the image to be properly displayed on screen (if need)
  Function to reset SettingPane:
    clear all elements in ops
    re-initialize player_num
    call Add-option-image function
    change prompt's label to "player 1 ..."
  showContents (override):
    add label and prompt
    loop of ops size:
      add each of ops's element
  hideContents (override):
    remove pane label and prompt
    loop of ops size:
      remove each elements in ops
    call reset function
  mousePressed:
    loop of ops size:
      if player press any of ops's elements:
        change player_name of GraphicsGame to the name of this element
        remove this element's image from screen
        increment player_num by 1
      if it is turn of player 1:
        prompt player 2 to choose a icon (reset prompt label to "Player 2 ...")
      else if it is turn of player 2:
        switch back to MenuPane   
        
MainApplication:
  Create a private instance of SettingPane class (named "settingPane")
  run():
    Inotialize settingPane
  Create a new method to switch screen to SettingPane
MenuPane:
  Create a new instance of GImage (setting)
  MenuPane constructor:
    adjust other buttons to add setting button right after start/continue button
    initialize setting (setting button)
  showContents:
    add setting
  hideContents:
    remove setting
  mousePressed:
    if user press on the image setting:
      switch screen to SettingPane (using the new method created in MainApplication)
GraphicsGame:
  Change player_name to public static
  GraphicsGame contructor:
    delete setPlayerandMoneyLabel
  showContents:
    call setPlayerandMoneyLabel function
  

    
