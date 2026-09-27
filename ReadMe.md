| Valor | Salida de Factor | Código de Salida | 
| :--- | :--- | :--- |
| **360** | 360: 2 2 2 3 3 5 | Código de salida: 0 | 
| **1** | 1: | Código de salida: 0 |
| **17** | 17:17 | Código de salida: 0 |
| **hola** | factor: warning: hola: invalid digit found in string | Código de salida: 1 |
| **-5** | > error: unexpected argument '-5' found | Código de salida: 1 |

---

### En el proceso del código me di cuenta de que no había sacado el error al poner un valor NO Intger en el factor, por lo que al poner hola salía null, cuendo tendría que salir "factor: 'hola' is not a valid positive integer", y claro, lo mismo pasó con -5
### Esto se solucionó añadiendo la línea "pb.redirectErrorStream(true);", con esta línea se consigue el mensaje de error de terminal.