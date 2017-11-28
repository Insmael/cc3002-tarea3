package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ModelTests.class,
        NumericDeckTest.class,
        PlayerListBuilderTest.class,
        PlayerTest.class,
        UnoCardPilesManagerTest.class,
        UnoCardPileTest.class,
        UnoCardTest.class,
        UnoLogicTest.class,
        UnoPlayerManagerTest.class
        
})

public class TestSuitcase {


}
