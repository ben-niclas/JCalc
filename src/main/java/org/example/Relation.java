package org.example;

// This Class functions as an interface for evaluating truth values
// of Statements; Because evalState should be equal across all Relations
// This class is not an interface
public abstract class Relation extends Statement {
    public Statement lhs;
    public Statement rhs;

    // To be implemented by actual Relations
    public abstract  Boolean compare();

    public Boolean evalState() {
        return lhs.isTrue && rhs.isTrue && compare();
    }
}
