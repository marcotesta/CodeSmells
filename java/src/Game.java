public class Game {
    private char _lastSymbol = ' ';
    private Symbol lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }


    public void Play(Symbol symbol, int x, int y) throws Exception {
        //if first move
        if (lastSymbol == Symbol.EMPTY) {
            //if player is X
            if (symbol == Symbol.O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).SymbolNew != Symbol.EMPTY) {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        for (int i=0; i < 3; i++) {
            if (sameSymbolsInRow(i)) {
                return _board.TileAt(i, 0).Symbol;
            }
        }
        return ' ';
    }
    public Symbol WinnerNEW() {
        for (int i=0; i < 3; i++) {
            if (sameSymbolsInRowNEW(i)) {
                return _board.TileAt(i, 0).SymbolNew;
            }
        }
        return Symbol.EMPTY;
    }

    private boolean sameSymbolsInRow(int x) {
        return _board.TileAt(x, 0).Symbol == _board.TileAt(x, 1).Symbol
                && _board.TileAt(x, 2).Symbol == _board.TileAt(x, 1).Symbol
                && _board.TileAt(x, 0).Symbol != ' ';
    }
    private boolean sameSymbolsInRowNEW(int x) {
        return _board.TileAt(x, 0).SymbolNew == _board.TileAt(x, 1).SymbolNew
                && _board.TileAt(x, 2).SymbolNew == _board.TileAt(x, 1).SymbolNew
                && _board.TileAt(x, 0).SymbolNew != Symbol.EMPTY;
    }
}

