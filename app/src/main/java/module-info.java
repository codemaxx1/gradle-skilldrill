module edu.isu.cs.cs2263.App.main {
    requires javafx.controls;
    requires com.google.common;
    exports edu.isu.cs.cs2263;
    requires com.google.gson;
    //exports edu.isu.cs.cs2263.gson;
    opens edu.isu.cs.cs2263 to com.google.gson;
}