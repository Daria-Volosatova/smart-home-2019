package ru.sbt.mipt.oop.objects.alarm;

public class AlarmActivatedState implements AlarmState {
    private Alarm alarm;
    private String code;

    public AlarmActivatedState(Alarm alarm, String code){
        this.alarm = alarm;
        this.code = code;
    }

    public AlarmActivatedState(Alarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void activate(String inputPassword) {
        System.out.println("Alarm is already activated");
    }

    @Override
    public void deactivate(String inputPassword) {
        if (this.code.equals(inputPassword)){
            //System.out.println(this.code);

            // выключаем сигнализацию, если пароль введен верно
            AlarmState newState = new AlarmDeactivatedState(alarm);
            alarm.changeState(newState);
            System.out.println("Alarm deactivated");
        } else {
            System.out.println("Wrong password entered!");

            // если пароль введен неверно, переходим в состояние тревоги
            System.out.println("Sending sms");
            AlarmState newState = new AlarmAlertState(alarm, this.code);
            alarm.changeState(newState);
        };
    }

    @Override
    public void activateAlert() {
        alarm.changeState(new AlarmAlertState(alarm));
    }
}
