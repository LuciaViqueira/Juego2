import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner (System.in);

		System.out.println("Bienvenido al Juego 2 Numero Oculto");

		System.out.println("¿Que desea hacer?");

		//Variables
		int escogerOpcion = 0;
		int numIntUsuario = 0;
		int numMaxUsuario = 0;
		int numInt = 5;
		int numMax = 10;

		//Menu
		do {
			//Con el try catch comprobamos que no sea una letra
			try {
				System.out.println("1-Configuracion");
				System.out.println("2-Jugar");
				System.out.println("3-Salir");
				escogerOpcion = teclado.nextInt();
			}catch(Exception e) {
				System.out.println("No has introducido un numero");
				teclado.next();
			}

			//No aseguramos que los numeros introducidos sean entre 1 y 3
		}while(escogerOpcion != 1 && escogerOpcion !=2 && escogerOpcion !=3);


		//Elegir la primera opcion
		if(escogerOpcion==1) {
			System.out.println("Has entrado en menu Configuracion: ");
			
			//Pedimos el numero de intentos para adivinar el numero miramos que no se pueda introducir un caracter
			do {
				try {
					System.out.println("Introduzca el numero de intentos para jugar a adivinar el numero: ");
					numIntUsuario = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
					
				}
			}while(numIntUsuario==0);
			
			//Pedimos el numero max para adivinar y comprobamos que no sea un caracter
			do {
				try {
					System.out.println("Introduzca el numero maximo para jugar: ");
					numMaxUsuario = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
				}
			}while(numMaxUsuario==0);
			
			//Le pedimos al usuario que escoja si quiere jugar o salir
			do {
				//Comprobamos que no introduciomos un caracter
				try {
					System.out.println("Que quieres hacer");
					System.out.println("2-Jugar");
					System.out.println("3-Salir");
					escogerOpcion = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
				}

			}while(escogerOpcion !=2 && escogerOpcion !=3);
		}

		//Elegir segunda opcion
		if(escogerOpcion==2) {
			System.out.println("Has entrado en la opcion de Jugar");
			int aleatorio = (int) Math.floor(Math.random()*(numMax-0+1)+0);
			//System.out.println(aleatorio);

			//Llamamos a la funcion
			intentarAdivinar (numInt, numMax, aleatorio);
		}

		//Elegir tercera opcion
		if(escogerOpcion == 3) {

			System.out.println("Has salido del juego");
		}

	}
	private static void intentarAdivinar (int numInt, int numMax, int aleatorio ) {
		Scanner teclado = new Scanner (System.in);

		//Declaramos Variables
		int numOculto = 0;
		int contadorIntentos = 0;
		

		//Con el bucle for hacemos que se pida numero hasta que el numero de intentos se agote
		for(int i=0; i<numInt; i++) {

			do {
				try {
					System.out.println("Introduzca numero para adivinar el numero oculto");
					numOculto = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
				}
			}while(numOculto==0);
			
			contadorIntentos ++;

			//Aqui miramos las condiciones
			if(numOculto == aleatorio) {
				//Si acertamos el numero
				System.out.println("HAS ACERTADO :) " + "has necesitado " + contadorIntentos + " intentos para adivinar");
				break;
			}else if(contadorIntentos == numInt) {
				//Si nos quedamos sin intentos
				System.out.println("Perdiste!. Intentos consumidos :/");
			}else if(numOculto>aleatorio) {
				//Pista si ponemos un numero mayor que el aleatorio
				System.out.println("El numero oculto es menor ");
			}else if(numOculto<aleatorio) {
				//Pista si ponemos un numero menor que el aleatorio
				System.out.println("El numero oculto es mayor ");
			}
		}

	}


}
