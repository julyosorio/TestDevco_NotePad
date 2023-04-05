package co.com.iris.certification.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constants {

    public static final String WEB_EMPRESAS_QA_PRINCIPAL = "https://empresas.qa.iristesting.com.co";
    public static final String WEB_EMPRESAS_STG = "https://empresas.stg.iristesting.com.co";

    public static final String YOPMAIL = "https://yopmail.com/es/";
    public static final String MESSAGE_ERROR_WRONG_VALUE_TRX = "Digita el valor";
    public static final String VALUE_DEFAULT_FIELD_PERIODICITY = "Única vez";
    public static final String TRANSFER_DOESNT_HAVE_PERIODICITY = "No";
    public static final LocalDate TODAY = LocalDate.now();
    public static final DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final String DATE_CURRENT = esDateFormat.format(TODAY);
    public static final LocalDate START_DATE = TODAY.plusDays(2);
    public static final LocalDate END_DATE = TODAY.plusMonths(2);
    public static final String INITIAL_SCHEDULED_DATE = esDateFormat.format(START_DATE);
    public static final String FINAL_SCHEDULED_DATE = esDateFormat.format(END_DATE);
    public static final String SEPARATOR_FORMAT_DATE = "/";
    public static final String TRANSFER = "Transferencias";
    public static final String TRANSACTION_MESSAGE = "Comprobante de transferencia";

    public static final Long WAITING_TIME = 40L;

    public static final String OTHER_BANKS = "Otros bancos";
    public static final String IRIS_BANK = "Banco Iris";

    public static final String BANK_IRIS_NAME = "Iris";
    public static final String OWN_ACCOUNTS = "Cuentas propias";
    public static final String IRIS_ACCOUNTS = "Cuentas Iris";
    public static final String SELECT_VALUE_CALENDAR = "//div[@aria-disabled='false']";
    public static final String PAY_TYPE_PAYROLL = "payroll";
    public static final String PAY_TYPE_MANUAL_PAYROLL = "payroll manual";
    public static final String VALUE_PAY_TYPE_MANUAL_PAYROLL = "Manuales: Nóminas";
    public static final String PAY_TYPE_SUPPLIERS = "supplier";
    public static final String PAY_TYPE_MANUAL_SUPPLIER = "supplier manual";
    public static final String VALUE_PAY_TYPE_MANUAL_SUPPLIER = "Manuales: Proveedores";
    public static final String TYPE_OPERATION_TRANSFER = "Transferencia";
    public static final String TYPE_OPERATION_PAYMENTS = "Pagos";
    public static final String STATUS_TRANSFER_IN_PROCCESS = "En procesamiento";

    public static final String STATUS_TRANSFER_SUCCESSFUL = "Exitosa";
    public static final String DELETE_REGISTERED_ACCOUNT = "delete registered account";

    public static final String USER_CREATION = "creation of new users";
    public static final String USER_MODIFICATION = "user modification";

    public static final String MANUAL_PAYROLL = "Manuales: Nóminas";
    public static final String IN_LOT_PAYROLL = "En Lote: Nóminas";
    public static final String MANUAL_SUPPLIER_PAYMENT = "Manuales: Proveedores";
    public static final String IN_LOT_SUPPLIER_PAYMENT = "En Lote: Proveedores";

    public static final String SCENARIO_DELETE_PAYMENTS_FROM_LIST = "delete payments";
    public static final String SCENARIO_ADD_PAYMENTS_FROM_LIST = "add payments";
    public static final String SCENARIO_UPDATE_ORIGIN_ACCOUNT = "update origin account";
    public static final String SCENARIO_UPDATE_EXECUTE_DATE = "update execute date";
    private Constants() {
    }
}
