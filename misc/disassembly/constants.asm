; Initializing
DEF SP_INIT  EQU $cfff ; Initial location of Stack Pointer

; Screen constants
DEF SCREEN_HEIGHT EQU 144  ; Visible Pixels before VBlank ($90)
DEF SCREEN_WIDTH  EQU 160  ; Visible Pixels before HBlank ($A0)
DEF LCDC_ON       EQU $80  ; Turn LCDC on
DEF LCDC_STANDARD EQU $d3  ; LCDC, BG, Sprites on, Window Tile Map starts at $9c00,
                       ; BG & Window Tile Data starts at $8000,
                       ; BG Tile Map Display starts at $9800,
                       ; OBJ (Sprite) Size is set to 8x8 pixels

; Joypad constants (internal meaning: directional buttons in the upper nibble, numbers equal the bit set)
DEF BTN_RIGHT  EQU 4  ; Directional Right
DEF BTN_LEFT   EQU 5  ; Directional Left
DEF BTN_UP     EQU 6  ; Directional Up
DEF BTN_DOWN   EQU 7  ; Directional Down
DEF BTN_A      EQU 0  ; Button A
DEF BTN_B      EQU 1  ; Button B
DEF BTN_SELECT EQU 2  ; Button Select
DEF BTN_START  EQU 3  ; Button Start




; Sound constants
DEF SOUND_ON   EQU $80
DEF USE_ALL_CHANNELS   EQU $FF ; Set all audio channels to both output terminals (stereo)
DEF MASTER_VOLUME_MAX  EQU $77 ; Set both output terminals to highest volume
DEF ENVELOPE_NO_SOUND  EQU $08 ; Sets an envelope to no sound and direction to "increase"


; RAM constants
; c000-c09f is the OAM data source

DEF rSCORE1           EQU $c0a0 ; score, smallest digits, highest value = 99
DEF rSCORE2           EQU $c0a1 ; score, middle digits, highest value = 99 (= 9900)
DEF rSCORE3           EQU $c0a2 ; score, highest digits, highest value = 99 (= 990000)
DEF rLINE_CLEAR_START EQU $c0a3 ; $ca after clearing 1-3 line(s), $c9 after clearing 4 lines

DEF rUNKNOWN3   EQU $c0a4 ; ..

DEF rHIDE_NEXT_BLOCK            EQU $c0de ; 0 = normal, 1 = next block display hidden (toggled by select button. Keeps value even if hidden in pause menu.)

DEF rBLOCK_VISIBILITY   EQU $c200 ; 80 = invisible, 0 = visible
DEF rBLOCK_Y            EQU $c201 ; Y location of falling block
DEF rBLOCK_X            EQU $c202 ; X location of falling block
DEF rBLOCK_TYPE         EQU $c203 ; Block type of falling block (see list below)

DEF rNEXT_BLOCK_VISIBILITY   EQU $c210 ; 80 = invisible, 0 = visible
DEF rNEXT_BLOCK_Y            EQU $c211 ; Y location of next block (always $80)
DEF rNEXT_BLOCK_X            EQU $c212 ; X location of next block (always $8f)
DEF rNEXT_BLOCK_TYPE         EQU $c213 ; Block type of next block (see list below, always the first unrotated variant)

; Block types: (higher numbers mean counter-clockwise rotation. A-Button decreases number -> clockwise rotation)
                              ; ###
DEF rL_SHAPE_0          EQU $00   ; #
DEF rL_SHAPE_1          EQU $01
DEF rL_SHAPE_2          EQU $02
DEF rL_SHAPE_3          EQU $03
                              ; ###
DEF rREVERSE_L_SHAPE_0  EQU $04   ;   #
DEF rREVERSE_L_SHAPE_1  EQU $05
DEF rREVERSE_L_SHAPE_2  EQU $06
DEF rREVERSE_L_SHAPE_3  EQU $07

DEF rI_SHAPE_0          EQU $08   ; ####
DEF rI_SHAPE_1          EQU $09
DEF rI_SHAPE_2          EQU $0a
DEF rI_SHAPE_3          EQU $0b
                              ; ##
DEF rSQUARE_SHAPE_0     EQU $0c   ; ##
DEF rSQUARE_SHAPE_1     EQU $0d   ; (Yes the square can be rotated!)
DEF rSQUARE_SHAPE_2     EQU $0e
DEF rSQUARE_SHAPE_3     EQU $0f
                              ; ##
DEF rZ_SHAPE_0          EQU $10   ;  ##
DEF rZ_SHAPE_1          EQU $11
DEF rZ_SHAPE_2          EQU $12
DEF rZ_SHAPE_3          EQU $13
                              ;  ##
DEF rS_SHAPE_0          EQU $14   ; ##
DEF rS_SHAPE_1          EQU $15
DEF rS_SHAPE_2          EQU $16
DEF rS_SHAPE_3          EQU $17
                              ; ###
DEF rT_SHAPE_0          EQU $18   ;  #
DEF rT_SHAPE_1          EQU $19
DEF rT_SHAPE_2          EQU $1a
DEF rT_SHAPE_3          EQU $1b


DEF rHIDE_NEXT_BLOCK_DISPLAY    EQU $c210 ; 0 = normal, $80 = next block display hidden - DISPLAY (always $80 in pause menu)

DEF rPAUSED          EQU $df7f ; 00 = normal / paused, 01 = pause pressed, 02 = unpause pressed
DEF rPAUSE_CHIME     EQU $df7e ; 00 = normal, 11 = final value in pause menu after countdown, 30 = initial value when pause pressed

DEF rSOUND1     EQU $dfe1 ; (Set whenever a new sound is about to be played)
DEF rSOUND2     EQU $dfe9 ; ?
DEF rSOUND3     EQU $dff1 ; ?
DEF rSOUND4     EQU $dff9 ; ?
DEF rSOUND5     EQU $df9f ; ?
DEF rSOUND6     EQU $dfaf ; ?
DEF rSOUND7     EQU $dfbf ; ?
DEF rSOUND8     EQU $dfcf ; ?
DEF rSOUND9     EQU $df78 ; ?


; Hardware registers
DEF rMBC        EQU $2000 ; MBC Controller - Select ROM bank 0 (not needed in Tetris)
DEF rJOYP       EQU $ff00 ; Joypad (R/W)
DEF rSB         EQU $ff01 ; Serial transfer data (R/W)
DEF rSC         EQU $ff02 ; Serial Transfer Control (R/W)
DEF rSC_ON    EQU 7
DEF rSC_CGB   EQU 1
DEF rSC_CLOCK EQU 0
DEF rDIV        EQU $ff04 ; Divider Register (R/W)
DEF rTIMA       EQU $ff05 ; Timer counter (R/W)
DEF rTMA        EQU $ff06 ; Timer Modulo (R/W)
DEF rTAC        EQU $ff07 ; Timer Control (R/W)
DEF rTAC_ON        EQU 2
DEF rTAC_4096_HZ   EQU 0
DEF rTAC_262144_HZ EQU 1
DEF rTAC_65536_HZ  EQU 2
DEF rTAC_16384_HZ  EQU 3
DEF rIF         EQU $ff0f ; Interrupt Flag (R/W)
DEF rNR10       EQU $ff10 ; Channel 1 Sweep register (R/W)
DEF rNR11       EQU $ff11 ; Channel 1 Sound length/Wave pattern duty (R/W)
DEF rNR12       EQU $ff12 ; Channel 1 Volume Envelope (R/W)
DEF rNR13       EQU $ff13 ; Channel 1 Frequency lo (Write Only)
DEF rNR14       EQU $ff14 ; Channel 1 Frequency hi (R/W)
DEF rNR21       EQU $ff16 ; Channel 2 Sound Length/Wave Pattern Duty (R/W)
DEF rNR22       EQU $ff17 ; Channel 2 Volume Envelope (R/W)
DEF rNR23       EQU $ff18 ; Channel 2 Frequency lo data (W)
DEF rNR24       EQU $ff19 ; Channel 2 Frequency hi data (R/W)
DEF rNR30       EQU $ff1a ; Channel 3 Sound on/off (R/W)
DEF rNR31       EQU $ff1b ; Channel 3 Sound Length
DEF rNR32       EQU $ff1c ; Channel 3 Select output level (R/W)
DEF rNR33       EQU $ff1d ; Channel 3 Frequency's lower data (W)
DEF rNR34       EQU $ff1e ; Channel 3 Frequency's higher data (R/W)
DEF rNR41       EQU $ff20 ; Channel 4 Sound Length (R/W)
DEF rNR42       EQU $ff21 ; Channel 4 Volume Envelope (R/W)
DEF rNR43       EQU $ff22 ; Channel 4 Polynomial Counter (R/W)
DEF rNR44       EQU $ff23 ; Channel 4 Counter/consecutive; Initial (R/W)
DEF rNR50       EQU $ff24 ; Channel control / ON-OFF / Volume (R/W)
DEF rNR51       EQU $ff25 ; Selection of Sound output terminal (R/W)
DEF rNR52       EQU $ff26 ; Sound on/off
DEF rLCDC       EQU $ff40 ; LCD Control (R/W)

DEF rLCDC_STAT  EQU $ff41 ; LCDC Status (R/W)
DEF rSCY        EQU $ff42 ; Scroll Y (R/W)
DEF rSCX        EQU $ff43 ; Scroll X (R/W)
DEF rLY         EQU $ff44 ; LCDC Y-Coordinate (R)
DEF rLYC        EQU $ff45 ; LY Compare (R/W)
DEF rDMA        EQU $ff46 ; DMA Transfer and Start Address (W)
DEF rBGP        EQU $ff47 ; BG Palette Data (R/W)
DEF rOBP0       EQU $ff48 ; Object Palette 0 Data (R/W)
DEF rOBP1       EQU $ff49 ; Object Palette 1 Data (R/W)
DEF rWY         EQU $ff4a ; Window Y Position (R/W)
DEF rWX         EQU $ff4b ; Window X Position minus 7 (R/W)
DEF rIE         EQU $ffff ; Interrupt Enable (R/W)


; HRAM variables
DEF rBUTTON_DOWN     EQU $ff80 ; buttons currently pressed (lower nibble = buttons, higher nibble = directional keys)
DEF rBUTTON_HIT      EQU $ff81 ; buttons pressed for the first time
DEF rVBLANK_DONE     EQU $ff85 ; 1 = VBlank interrupt executed; 0 = Not executed yet

DEF rOAM_TILE_NO      EQU $ff89 ; temporary storage for OAM data of next transfer to $c000 - $c09f
DEF rOAM_ATTRIBUTE_NO EQU $ff8a ; "
DEF rUNKNOWN4         EQU $ff8b ; "
DEF rUNKNOWN5         EQU $ff8c ;

DEF rOAM_TILE_ADDRESS_1  EQU $ff8d ; higher byte of target OAM storage address (in $c000 - $c09f) for transfer from temporary storage in HRAM
DEF rOAM_TILE_ADDRESS_2  EQU $ff8e ; lower byte " "
DEF rAMOUNT_SPRITES_TO_DRAW  EQU $ff8f ; draws X amount of sprites starting at $c200, incrementing by $10

DEF rOAM_X_POS        EQU $ff92 ; temporary storage for OAM data of next transfer to $c000 - $c09f
DEF rOAM_Y_POS        EQU $ff93 ; "
DEF rUNKNOWN6         EQU $ff94 ; "
DEF rOAM_VISIBLE      EQU $ff95 ; " - $80 = invisible, $00 = visible

DEF rSPRITE_ORIGINAL_ADDRESS_1  EQU $ff96 ; higher byte of starting address of sprite info in $c200+
DEF rSPRITE_ORIGINAL_ADDRESS_2  EQU $ff97 ;  lower byte of starting address of sprite info in $c200+



DEF rBLOCK_STATUS    EQU $ff98 ; runs from 1 to 3 when block hits ground; back to 0 before chime and line clear handling

DEF rGRAVITY         EQU $ff99 ; loops from $0a to $00, block falls down by one when transitioning from $0a to $09

DEF rCLEAR_PROGRESS  EQU $ff9c ; runs from 1 to 7 during line clear animation

DEF rLINES_CLEARED1  EQU $ff9e ; smallest digits of cleared line number in decimal, so highest value = 99 - or lines left in game type B
DEF rLINES_CLEARED2  EQU $ff9f ; highest digits, highest value also 99 (meaning 9900), making 9999 the highest line number possible.

DEF rIE_TEMP         EQU $ffa1 ; used for temporary storage of IE ($ffff)

DEF rUNKNOWN1        EQU $ffa4 ; probably unused
DEF rCOUNTDOWN       EQU $ffa6 ; various uses - counts down one per VBlank (~59.7 times a second)
DEF rCOUNTDOWN2      EQU $ffa7 ; various uses - counts down one per VBlank  = 4 seconds per byte (256 values)

DEF rPAUSE_MENU      EQU $ffab ; 0 = normal, 1 = in pause menu

DEF rDEMO_STATUS     EQU $ffb0 ; $0 = normal, $03 - $0f = # of block in demo 1, $10 = back in main menu (between games)
                           ;              $11 - $1c = # of block in demo 2, $1d = back in main menu (after demo 2, before demo 1 again)

; $ffb6 - $ffb7 = DMA transfer routine

DEF rGAME_TYPE       EQU $ffc0 ; $37 = Type A, $77 = Type B
DEF rMUSIC_TYPE      EQU $ffc1 ; $1c = Music A, $1d = Music B, $1e = Music C, $1f = Music off
DEF rLEVEL_A         EQU $ffc2 ; current level (type A)
DEF rLEVEL_B         EQU $ffc3 ; current level (type B)
DEF rINITIAL_HEIGHT  EQU $ffc4 ; height of blocks (Type B)
DEF rPLAYERS         EQU $ffc5 ; 0 = 1 player, 1 = 2 players
DEF rMUSIC_COUNTDOWN EQU $ffc6 ; countdown for title screen music - until demo game starts playing (reduces by one whenever rCOUNTDOWN reaches 0)
DEF rUNKNOWN7        EQU $ffca ; related to hiscore entry
DEF rUNKNOWN8        EQU $ffcb ; ?Must be $29 to consider sending data in VBlank..
DEF rREQUEST_SERIAL_TRANSFER        EQU $ffce ; Request serial connection data transfer
DEF rSB_DATA         EQU $ffcf ; Holds the data to be sent via link cable
DEF rGAME_STATUS     EQU $ffe1 ; See table below:
    ; $00 = in-game (both game types)
    ; $01 = shortly before game over screen
    ; $02 = !rocket launch 4
    ; $03 = !rocket launch 5
    ; $04 = game over screen
    ; $05 = type B winning chime
    ; $06 = shortly before title screen
    ; $07 = title screen
    ; $08 = shortly before game type selection
    ; $09 = nothing
    ; $0a = shortly before in-game
    ; $0b = showing score (type B)
    ; $0c = !leads to 02
    ; $0d = game lost animation (screen filling with bricks)
    ; $0e = game type selection (top screen)
    ; $0f = music selection (bottom screen)
    ; $10 = shortly before choose level (type A)
    ; $11 = choose level (type A)
    ; $12 = shortly before choose level (type B)
    ; $13 = choose level (type B)
    ; $14 = select "high" / initial random block height (type B)
    ; $15 = enter hiscore name (type A & B)
    ; $16 = !shortly before "Mario vs. Luigi" screen
    ; $17 = !"Mario vs. Luigi" screen
    ; $18 = !shortly before "Mario vs. Luigi" gameplay
    ; $19 = !"Mario vs. Luigi" gameplay
    ; $1A = !before 1B
    ; $1B = !before Luigi won
    ; $1C = !also before 1B
    ; $1D = !shortly before Luigi won screen
    ; $1E = !shortly before Luigi lost screen
    ; $1F = !before 16
    ; $20 = !Luigi won screen
    ; $21 = !Luigi lost screen
    ; $22 = !Shortly before congratulations animation 1
    ; $23 = !congratulations animation 1
    ; $24 = initial value copyright screen (very short)
    ; $25 = copyright screen during first countdown
    ; $26 = !rocket launch init
    ; $27 = !rocket launch 1
    ; $28 = !rocket launch 2
    ; $29 = !rocket launch 3
    ; $2A = !before 2B
    ; $2B = !before 16
    ; $2C = !rocket launch 6
    ; $2D = !rocket launch 7
    ; $2E = !rocket launch b1
    ; $2F = !rocket launch b2
    ; $30 = !rocket launch b3
    ; $31 = !rocket launch b4
    ; $32 = !rocket launch b5
    ; $33 = !rocket launch b6
    ; $34 = !shortly before rocket launch b
    ; $35 = copyright screen during second countdown


DEF rCOUNT_UP       EQU $ffe2 ; Counts from $00 to $FF (once per frame) - various uses
DEF rROW_UPDATE     EQU $ffe3 ; current line to move down (after removing line(s))
DEF rDEMO_GAME      EQU $ffe4 ; 0 = normal game, 2 = first demo game (type A), 1 = second demo game (type B)

DEF rUNUSED             EQU $ffe9 ; set only in unused function. but tested everywhere. What a waste.
DEF rDEMO_ACTION_COUNTDOWN  EQU $ffea ; counts down the frames a button press (or none) is required acc. to storyboard (gravity works anyway)
DEF rDEMO_STORYBOARD_1  EQU $ffeb ; upper address of demo storyboard
DEF rDEMO_STORYBOARD_2  EQU $ffec ; lower address of demo storyboard
DEF rDEMO_BUTTON_HIT    EQU $ffed ; simulated button presses (see joypad constants above)
DEF rDEMO_ACTUAL_BUTTON EQU $ffee ; saves the actual button presses (after handling simulated ones), and then handles them (= Start btn to quit demo)

DEF rHARD_MODE      EQU $fff4 ; 0 = off, 88 = on

; Variable value constants:
DEF GAME_TYPE_A     EQU   $37
DEF GAME_TYPE_B     EQU   $77

DEF MUSIC_TYPE_A    EQU   $1c
DEF MUSIC_TYPE_B    EQU   $1d
DEF MUSIC_TYPE_C    EQU   $1e
DEF MUSIC_TYPE_OFF  EQU   $1f

DEF MENU_IN_GAME          EQU   $00
DEF MENU_GAME_OVER_INIT   EQU   $01
DEF MENU_GAME_OVER        EQU   $04
DEF MENU_TYPE_B_WON       EQU   $05
DEF MENU_TITLE_INIT       EQU   $06
DEF MENU_TITLE            EQU   $07
DEF MENU_SELECT_TYPE_INIT EQU   $08
DEF MENU_IN_GAME_INIT     EQU   $0a
DEF MENU_SCORE_B          EQU   $0b
DEF MENU_LOST_ANIM        EQU   $0d
DEF MENU_SELECT_TYPE      EQU   $0e
DEF MENU_SELECT_MUSIC     EQU   $0f
DEF MENU_LEVEL_A_INIT     EQU   $10
DEF MENU_LEVEL_A          EQU   $11
DEF MENU_LEVEL_B_INIT     EQU   $12
DEF MENU_LEVEL_B          EQU   $13
DEF MENU_HIGH_B           EQU   $14
DEF MENU_HISCORE          EQU   $15
DEF MENU_COPYRIGHT_INIT   EQU   $24
DEF MENU_COPYRIGHT_1      EQU   $25
DEF MENU_COPYRIGHT_2      EQU   $35
DEF MENU_ROCKET_1_INIT    EQU   $26
DEF MENU_ROCKET_1A        EQU   $27
DEF MENU_ROCKET_1B        EQU   $28
DEF MENU_ROCKET_1C        EQU   $29
DEF MENU_ROCKET_1D        EQU   $02
DEF MENU_ROCKET_1E        EQU   $03
DEF MENU_ROCKET_1F        EQU   $2C
DEF MENU_ROCKET_1G        EQU   $2D
DEF MENU_ROCKET_2_INIT    EQU   $34
DEF MENU_ROCKET_2A        EQU   $2E
DEF MENU_ROCKET_2B        EQU   $2F
DEF MENU_ROCKET_2C        EQU   $30
DEF MENU_ROCKET_2D        EQU   $31
DEF MENU_ROCKET_2E        EQU   $32
DEF MENU_ROCKET_2F        EQU   $33
DEF MENU_CELEBRATE        EQU   $22
DEF MENU_VS_INIT          EQU   $16
DEF MENU_VS_MODE          EQU   $17
DEF MENU_VS_GAME_INIT     EQU   $18
DEF MENU_VS_GAME          EQU   $19
DEF MENU_LUIGI_WON_INIT   EQU   $1d
DEF MENU_LUIGI_LOST_INIT  EQU   $1e
DEF MENU_LUIGI_WON        EQU   $20
DEF MENU_LUIGI_LOST       EQU   $21
