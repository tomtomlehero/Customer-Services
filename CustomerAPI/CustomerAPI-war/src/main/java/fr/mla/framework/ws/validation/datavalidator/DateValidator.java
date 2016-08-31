package fr.mla.framework.ws.validation.datavalidator;

import fr.mla.framework.ws.validation.util.ValidationErrors;

import java.util.Calendar;
import java.util.Date;

public class DateValidator extends AbstractDataValidator<Date> {

    private static final long MILLIS_PER_HOUR = 3600000;



    public DateValidator(Date data, ValidationErrors validationErrors) {
        super(data, validationErrors);
    }


    @Override
    public DateValidator notNull(String message) {
        return (DateValidator) super.notNull(message);
    }


    public DateValidator after(Date that, String message) {
        if (this.data != null && that != null) {
            if (!this.data.after(that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DateValidator before(Date that, String message) {
        if (this.data != null && that != null) {
            if (!this.data.before(that)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DateValidator past(String message) {
        if (this.data != null) {
            if (!this.data.before(new Date())) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }

    public DateValidator future(String message) {
        if (this.data != null) {
            if (!this.data.after(new Date())) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }


    public DateValidator isDate(String message) {
        if (this.data != null) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.data);

            long hourOfDayNoTimeZonOffset = (calendar.get(Calendar.HOUR_OF_DAY) * MILLIS_PER_HOUR - calendar.getTimeZone().getOffset(calendar.getTimeInMillis())) / MILLIS_PER_HOUR;

            if ((hourOfDayNoTimeZonOffset  != 0)
                    || (calendar.get(Calendar.MINUTE) != 0)
                    || (calendar.get(Calendar.SECOND) != 0)
                    || (calendar.get(Calendar.MILLISECOND) != 0)) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }


    public DateValidator isDateTime(String message) {
        if (this.data != null) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.data);

            if (calendar.get(Calendar.MILLISECOND) != 0) {
                this.validationErrors.add(message);
            }
        }
        return this;
    }




}
