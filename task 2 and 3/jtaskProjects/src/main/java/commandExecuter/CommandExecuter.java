package commandExecuter;


import entities.Command;
import operations.CommandOperation;

import java.lang.reflect.*;

import dataCarrier.DataCarrier;

public class CommandExecuter {
	public static DataCarrier execute(String commandString, DataCarrier dataCarrier) throws Exception { // void düzeltilebilir.
		try {
			CommandOperation cmdOp = new CommandOperation();
			Command command = cmdOp.getCommand(commandString);
			if (!isValue(command)) {
				throw new Exception("Command not found!");
			}

			Class<?> c = Class.forName("operations." + command.getClassName() + "Operation");
			//Object obj = c.newInstance();
			Object obj = c.getDeclaredConstructor().newInstance();
			Method method;
			DataCarrier dc;
			if (!dataCarrier.getMap().isEmpty()) {
				System.out.println(DataCarrier.class);
				method = c.getDeclaredMethod(command.getMethodName(), DataCarrier.class);
				dc = (DataCarrier) method.invoke(obj, dataCarrier);

			} else {
				method = c.getDeclaredMethod(command.getMethodName());
				dc = (DataCarrier) method.invoke(obj);
			}
			System.out.println("Command executer runed");
			return dc;

		} catch (Exception e) {
			System.out.println("Command executer failed");
			e.printStackTrace();
			throw e;
		}
	}
		

	private static boolean isValue(Command command) {
		if (command == null) {
			System.out.println("bulunamadı");
			return false;
		}
		System.out.println("-> Command Information; \n\t" + command.getCommandName() + "\n\t"
				+  "\n\t" + command.getClassName() + "\n\t" + command.getMethodName());
		return true;
	}
}

